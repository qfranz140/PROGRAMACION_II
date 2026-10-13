from JuegoAdivinaNumero import JuegoAdivinaNumero


class Aplicacion:
    def main():
        # 1. Creamos la instancia de la nueva clase JuegoAdivinaNumero (con 3 vidas iniciales)
        partida = JuegoAdivinaNumero(3)
        # 2. Llamamos al método juega a través de la instancia creada
        partida.juega()
Aplicacion.main()