from JuegoAdivinaNumero import JuegoAdivinaNumero
from JuegoAdivinaPar import JuegoAdivinaPar
from JuegoAdivinaImpar import JuegoAdivinaImpar
class Aplicacion:
    @staticmethod
    def main():
        # 1. Creamos una instancia de cada juego, con 3 vidas
        juego1 = JuegoAdivinaNumero(3)
        juego2 = JuegoAdivinaPar(3)
        juego3 = JuegoAdivinaImpar(3)

        # 2. Llamamos al método juega de cada instancia
        print("Numero")
        juego1.juega()
        print("Par")
        juego2.juega()
        print("Impar")
        juego3.juega()
Aplicacion.main()