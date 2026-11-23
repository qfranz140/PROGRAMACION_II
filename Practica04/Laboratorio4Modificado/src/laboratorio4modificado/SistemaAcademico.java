/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio4modificado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author qfranz
 */
// ------ -------------- ------------- -------------- ---------
// Herencia : Persona ( abstracta ) <- Estudiante , Docente
// Herencia : Estudiante <- Ayudante
// ------ -------------- ------------- -------------- ---------

abstract class Persona {

    private final String nombre;
    private final String ci;

    protected Persona(String nombre, String ci) {
        this.nombre = nombre;
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCi() {
        return ci;
    }

    @Override
    public abstract String toString();
}

class Estudiante extends Persona {

    private final String codigo;
// Asociacion : el estudiante conoce sus inscripciones
    private final List<Inscripcion> inscripciones = new ArrayList<>();

    public Estudiante(String nombre, String ci, String codigo) {
        super(nombre, ci);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    // Correccion : no permite inscribirse dos veces en la misma materia
    public Inscripcion inscribirse(Materia materia) {
        for (Inscripcion i : inscripciones) {
            if (i.getMateria() == materia) {
                throw new IllegalStateException(
                        "El estudiante ya esta inscrito en " + materia.getCodigo());
            }
        }
        Inscripcion inscripcion = new Inscripcion(this, materia, LocalDate.now());
        inscripciones.add(inscripcion);
        materia.registrarInscripcion(inscripcion);
        return inscripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return Collections.unmodifiableList(inscripciones);
    }

    @Override
    public String toString() {
        return " Estudiante " + getNombre() + " ( codigo " + codigo + ")";
    }
}

// ------ -------------- ------------- -------------- ---------
// Herencia : Ayudante es un Estudiante
// Asociacion 1 a 1 : el Ayudante colabora con un Docente
// ------ -------------- ------------- -------------- ---------
class Ayudante extends Estudiante {

    // Asociacion : el ayudante colabora con un docente
    private final Docente docente;

    public Ayudante(String nombre, String ci, String codigo, Docente docente) {
        super(nombre, ci, codigo);
        if (docente == null) {
            throw new IllegalArgumentException("Un ayudante necesita un docente");
        }
        this.docente = docente;
        docente.registrarAyudante(this);
    }

    public Docente getDocente() {
        return docente;
    }

    @Override
    public String toString() {
        return " Ayudante " + getNombre() + " ( codigo " + getCodigo()
                + ") colabora con " + docente.getNombre();
    }
}

class Docente extends Persona {

    private final String especialidad;
// Asociacion : el docente conoce las materias que dicta
    private final List<Materia> materias = new ArrayList<>();
// Asociacion 1 a 1 : el docente conoce a su ayudante (null si aun no tiene)
    private Ayudante ayudante;
// Agregacion : la carrera a la que pertenece el docente (null si no tiene)
    private Universidad.Carrera carrera;

    public Docente(String nombre, String ci, String especialidad) {
        super(nombre, ci);
        this.especialidad = especialidad;
    }

    // Correccion : una materia no puede tener dos docentes
    public void dictar(Materia materia) {
        if (materia.getDocente() != null) {
            throw new IllegalStateException(
                    "La materia " + materia.getCodigo() + " ya tiene docente");
        }
        materias.add(materia);
        materia.setDocente(this);
    }
// Dependencia : Acta se crea y se devuelve , pero NO se guarda como atributo

    public Acta generarActa(Materia materia) {
        return new Acta(materia);
    }

    public List<Materia> getMaterias() {
        return Collections.unmodifiableList(materias);
    }

    void registrarAyudante(Ayudante ayudante) {
        if (this.ayudante != null) {
            throw new IllegalStateException("El docente ya tiene un ayudante");
        }
        this.ayudante = ayudante;
    }

    public Ayudante getAyudante() {
        return ayudante;
    }

    Universidad.Carrera getCarrera() {
        return carrera;
    }

    void setCarrera(Universidad.Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return " Docente " + getNombre() + " (" + especialidad + ")";
    }
}
// ------ -------------- ------------- -------------- ---------
// Composicion : Universidad -> Carrera (clase anidada)
// ------ -------------- ------------- -------------- ---------
class Universidad {

    private final String nombre;
    private final List<Carrera> carreras = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }
// La Universidad CREA a las partes ( carreras : no existen fuera de la Universidad)
    public Carrera crearCarrera(String nombreCarrera) {
        Carrera d = new Carrera(nombreCarrera);
        carreras.add(d);
        return d;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Carrera> getCarreras() {
        return Collections.unmodifiableList(carreras);
    }

    // ------ -------------- ------------- -------------- ---------
    // Agregacion : Carrera -> Docente
    // ------ -------------- ------------- -------------- ---------
    public static class Carrera {

        private final String nombre;
        private final List<Docente> docentes = new ArrayList<>();

        // Correccion : constructor private, solo Universidad puede crearla
        private Carrera(String nombre) {
            this.nombre = nombre;
        }
// La Carrera AGREGA a las partes ya existentes

        public void agregarDocente(Docente docente) {
            if (docentes.contains(docente)) {
                throw new IllegalStateException("El docente ya esta en esta carrera");
            }
            if (docente.getCarrera() != null) {
                throw new IllegalStateException("El docente ya pertenece a otra carrera");
            }
            docentes.add(docente);
            docente.setCarrera(this);
        }

        public String getNombre() {
            return nombre;
        }

        public List<Docente> getDocentes() {
            return Collections.unmodifiableList(docentes);
        }
    }
}
// ------ -------------- ------------- -------------- ---------
// Composicion : Materia -> Horario (clase anidada)
// ------ -------------- ------------- -------------- ---------

class Materia {

    private final String codigo;
    private final int creditos;
    private Docente docente;
    private final List<Horario> horarios = new ArrayList<>();
    private final List<Inscripcion> inscripciones = new ArrayList<>();

    public Materia(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public Horario agregarHorario(LocalDate fecha, String aula) {
        Horario s = new Horario(fecha, aula);
        horarios.add(s);
        return s;
    }

    void registrarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public Docente getDocente() {
        return docente;
    }

    public List<Horario> getHorarios() {
        return Collections.unmodifiableList(horarios);
    }

    public List<Inscripcion> getInscripciones() {
        return Collections.unmodifiableList(inscripciones);
    }

    public static class Horario {

        private final LocalDate fecha;
        private final String aula;

        // Correccion : constructor private, solo Materia puede crearlo
        private Horario(LocalDate fecha, String aula) {
            this.fecha = fecha;
            this.aula = aula;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public String getAula() {
            return aula;
        }
    }
}
// ------ -------------- ------------- -------------- ---------
// Inscripcion implementa Calificable
// Asociacion : el estudiante conoce sus inscripciones
// Asociacion : la materia tiene sus inscripciones
// ------ -------------- ------------- -------------- ---------
interface Calificable {

    double calcularNota();
}

class Inscripcion implements Calificable {

    private final Estudiante estudiante;
    private final Materia materia;
    private final LocalDate fecha;
    private Double nota;   // null = aun sin calificar

    Inscripcion(Estudiante estudiante, Materia materia, LocalDate fecha) {
        this.estudiante = estudiante;
        this.materia = materia;
        this.fecha = fecha;
    }

    public void registrarNota(double nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 100");
        }
        this.nota = nota;
    }

    public boolean estaCalificada() {
        return nota != null;
    }

    @Override
    public double calcularNota() {
        if (nota == null) {
            throw new IllegalStateException("La nota aun no fue registrada");
        }
        return nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
// ------ -------------- ------------- -------------- ---------
// Dependencia : Docente usa Acta de forma temporal
// ------ -------------- ------------- -------------- ---------

class Acta {

    private final LocalDate fecha = LocalDate.now();
    private final String contenido;

    Acta(Materia materia) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ACTA ").append(materia.getCodigo()).append(" - ").append(fecha).append("\n");
        for (Inscripcion i : materia.getInscripciones()) {
            sb.append(" ").append(i.getEstudiante().getNombre()).append(": ")
              .append(i.estaCalificada() ? String.valueOf(i.calcularNota()) : "sin nota")
              .append("\n");
        }
        this.contenido = sb.toString();
    }

    @Override
    public String toString() {
        return contenido;
    }
}

/**
 * Sistema academico : ejemplo de relaciones entre clases en UML/ Java .
 *
 */
public class SistemaAcademico {

    public static void main(String[] args) {
// Composicion : la Universidad crea sus Carreras
        Universidad umsa = new Universidad(" UMSA ");
        Universidad.Carrera informatica = umsa.crearCarrera(" Informatica ");
// Agregacion : los Docentes existen antes e independientemente de la Materia
        Docente docente = new Docente("Ana Alba ", " 1234567 ", " Ingenieria de Software ") ;
        informatica.agregarDocente(docente);
// Asociacion : el Docente dicta una Materia
        Materia poo = new Materia("INF -121 ", 6);
        docente.dictar(poo);
// Composicion : la Materia crea sus Horarios
        poo.agregarHorario(LocalDate.of(2026, 07, 2), " Aula 101");
        poo.agregarHorario(LocalDate.of(2026, 07, 9), " Aula 101");
// Asociacion entre Estudiante e Inscripcion
        Estudiante e1 = new Estudiante(" Carlos Flores ", " 7654321 ", "E -001 ");
        Estudiante e2 = new Estudiante(" Maria Salas ", " 7654322 ", "E -002 ");
        Inscripcion i1 = e1.inscribirse(poo);
        Inscripcion i2 = e2.inscribirse(poo);
        i1.registrarNota(85);
        i2.registrarNota(92);
// Herencia + polimorfismo
        List<Persona> personas = Arrays.asList(docente, e1, e2);
        personas.forEach(p -> System.out.println(p));
// La inscripcion se usa a traves de la interfaz Calificable
        Calificable c = i1;
        System.out.println(" Nota de " + e1.getNombre() + ": " + c.calcularNota()
        );
// Dependencia : el Docente usa Acta solo dentro de un metodo
        Acta acta = docente.generarActa(poo);
        System.out.println(acta);

// Ejemplo del Ayudante (descomentar para probar; agrega una linea a la salida)
// Ayudante a1 = new Ayudante(" Pedro Rios ", " 7654323 ", "E -003 ", docente);
// System.out.println(a1);
    }
}