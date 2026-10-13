class Sensor:
    tipo= "Generico"
    def __init__(self, id: str, **kwargs):
        self.id = id
        self.encendido = False
    def activar(self):
        self.encendido = True
        print(self.tipo, "Sensor: ", self.id, "Activado")
    def desactivar(self):
        self.encendido = False
        print(self.tipo, "Sensor: ", self.id, "Desactivado")