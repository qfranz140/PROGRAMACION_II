from clase import Calamar, CriaturaMarina, Delfin, Mamifero

n= "flipper"
elementos = [ Calamar (n) , Delfin (n) , Mamifero (n) , CriaturaMarina (n) ]
for i in range (0 , len ( elementos ) , 1) :
    elementos [ i ]. metodo2 ()
    print ( elementos [ i ])
    elementos [ i ]. metodo1 ()
    print ()
