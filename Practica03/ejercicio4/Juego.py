class Juego:
    def __init__(self, vidas, record):
        self.numeroDeVidas = vidas
        self.record = record

    def reiniciaPartida(self):
        pass

    def actualizaRecord(self):
        if self.numeroDeVidas > self.record:  
            self.record = self.numeroDeVidas
        print("El record es: " , self.record)

    def quitaVida(self):
        self.numeroDeVidas = self.numeroDeVidas - 1
        if self.numeroDeVidas > 0:  
            return True
        else:
            return False