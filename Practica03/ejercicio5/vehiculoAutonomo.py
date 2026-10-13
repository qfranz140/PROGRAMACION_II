from camara import Camara
from sensorLuzLaser import SensorLuzLaser

class VehiculoAutonomo(Camara, SensorLuzLaser):
    tipo="VehiculoAutonomo"
    def __init__(self, id: str, resolucion: str, alcance:int):
        super().__init__(id=id, resolucion=resolucion, alcance=alcance)
