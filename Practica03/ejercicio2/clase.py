class CriaturaMarina :
    def __init__ ( self, nombre ) :
        self.nombre = nombre

    def metodo1 ( self ) :
        print ("criatura 1")

    def metodo2 ( self ) :
        print ("criatura 2")

    def __str__ ( self ) :
        return f"criatura marina: {self.nombre}"


class Mamifero ( CriaturaMarina ) :
    def __init__ ( self, nombre ) :
        super().__init__ ( nombre )

    def metodo1 ( self ) :
        print ("sangre caliente")

    def __str__ ( self ) :
        return f"mamifero: {self.nombre}"


class Delfin ( Mamifero ) :
    def __init__ ( self, nombre ) :
        super().__init__ ( nombre )

    def metodo1 ( self ) :
        print ("sopla burbujas")
        super().metodo1()

    def __str__ ( self ) :
        return f"delfin: {self.nombre}"


class Calamar (CriaturaMarina) :
    def __init__ ( self, nombre ) :
        super().__init__ ( nombre )

    def metodo2 ( self ) :
        print ("tentaculos")

    def __str__ ( self ) :
        return f"calamar: {self.nombre}"


class Ballena (Mamifero):
    def __init__ (self, nombre):
        super().__init__(nombre)

    def metodo1(self):
        print("Canta canciones")

    def __str__(self):
        return f"ballena: {self.nombre}"

    def nadar(self):
        print("nada Profundamente")
