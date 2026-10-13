from sensor import Sensor
class SensorLuzLaser(Sensor):
    tipo = "LuzLaser"
    def __init__(self, id:str, alcance:int, **kwargs):
        super().__init__(id=id, **kwargs)
        
        self.alcance = alcance
