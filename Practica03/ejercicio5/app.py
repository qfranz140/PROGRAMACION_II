from sensor import Sensor
from camara import Camara
from sensorLuzLaser import SensorLuzLaser
from vehiculoAutonomo import VehiculoAutonomo


class Aplicacion:
    @staticmethod
    def main():
        # 1. Creamos una instancia de cada clase
        sensor = Sensor("S-01")
        camara = Camara("C-01", "1920x1080")
        laser = SensorLuzLaser("L-01", 150)
        vehiculo = VehiculoAutonomo("V-01", "3840x2160", 200)

        #Atributos de la clase
        print("Atributos de clase (tipo)")
        print(Sensor.tipo)
        print(Camara.tipo)
        print(SensorLuzLaser.tipo)
        print(VehiculoAutonomo.tipo)

        #Atributos de objeto
        print("Atributos de instancia del vehiculo")
        print(vehiculo.id)
        print(vehiculo.encendido)
        print(vehiculo.resolucion)
        print(vehiculo.alcance)

        #Metodos heredado
        print("Metodos")
        vehiculo.activar()
        print(vehiculo.encendido)
        vehiculo.desactivar()
        print(vehiculo.encendido)

        #Imprimimos el MRO
        print("MRO")
        for clase in VehiculoAutonomo.__mro__:
            print(clase.__name__)


Aplicacion.main()