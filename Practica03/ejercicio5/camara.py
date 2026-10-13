from sensor import Sensor
class Camara(Sensor):
    tipo = "camara"
    def __init__(self, id: str, resolucion: str, **kwargs):
        super().__init__(id=id, **kwargs)
        
        self.resolucion = resolucion
    