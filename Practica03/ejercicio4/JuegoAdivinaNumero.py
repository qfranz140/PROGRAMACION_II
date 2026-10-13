import random
from multimethod import multimethod
from Juego import Juego


class JuegoAdivinaNumero(Juego):
    def __init__(self, vidas):
        super().__init__(vidas, 0)
        self.numeroAdivinar = 0

    def validaNumero(self, validar):
        if validar > -1 and validar < 11:
            return True
        else: 
            return False

    def validaNumero(self, validar: str):
            validar = int(validar)
            if validar > -1 and validar < 11:
                return True
            else: 
                return False

    def juega(self):
        self.reiniciaPartida()
        self.numeroAdivinar = random.randint(0, 10)

        while not self.validaNumero(str(self.numeroAdivinar)):
            self.numeroAdivinar = random.randint(0, 10)
        #print(self.numeroAdivinar)

        while True:
            print("Adivina un numero entre 0 y 10")
            ni = int(input("Ingrese un numero:  "))
            if self.validaNumero(ni):
                if ni == self.numeroAdivinar:
                    print("ACERTASTE!!!")
                    self.actualizaRecord()
                    return
                else:
                    if self.quitaVida():
                        print("Perdiste una Vida")
                        print("Ahora tienes: " , self.numeroDeVidas , " vidas")
                        if self.numeroAdivinar > ni:
                            print("El numero a adivinar es Mayor")
                            print(" ")
                        else:
                            print("El numero a adivinar es menor")
                            print(" ")  
                    else:
                        print("PERDISTE YA NO TIENES VIDAS")
                        return
            else: 
                print("EL NÚMERO INGRESADO NO ESTA EN EL RANGO")