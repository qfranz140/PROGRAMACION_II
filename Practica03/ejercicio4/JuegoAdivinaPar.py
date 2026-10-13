from JuegoAdivinaNumero import JuegoAdivinaNumero
from multimethod import multimethod


class JuegoAdivinaPar(JuegoAdivinaNumero):
    def __init__(self, vidas):
        super().__init__(vidas)
        
    @multimethod
    def validaNumero(self, numero: int):
        print("Adivina par")
        if numero > -1 and numero < 11 and numero%2 == 0:
            return True
        else:
            print("ERROR: Número debe ser par y estar en el rango")
            return False

    @multimethod
    def validaNumero(self, numero: str):
        numero = int(numero)
        if numero > -1 and numero < 11 and numero%2 == 0:
            return True
        else:
            return False
    

    