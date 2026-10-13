from JuegoAdivinaNumero import JuegoAdivinaNumero
from multimethod import multimethod

class JuegoAdivinaImpar(JuegoAdivinaNumero):
    def __init__(self, vidas):
        super().__init__(vidas)
    @multimethod
    def validaNumero(self, numero):
        print("Adivina impar")
        if numero > -1 and numero < 11 and numero%2 != 0:
            return True
        else:
            print("ERROR: Número debe ser impar y estar en el rango")
            return False


    @multimethod
    def validaNumero(self, numero: str):
            numero = int(numero)
            if numero > -1 and numero < 11 and numero%2 != 0:
                return True
            else:
                return False