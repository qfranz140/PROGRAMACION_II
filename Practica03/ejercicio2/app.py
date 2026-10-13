from clase import Ballena, Calamar, CriaturaMarina, Delfin, Mamifero

n = "Flipper"
elementos = [
    Calamar(n),
    Delfin(n),
    Mamifero(n),
    CriaturaMarina(n),
    Ballena(n),
]
for i in range (len ( elementos ) ) :
    print ( elementos [ i ])
    elementos [ i ]. metodo1 ()
    elementos [ i ]. metodo2 ()
    print ()