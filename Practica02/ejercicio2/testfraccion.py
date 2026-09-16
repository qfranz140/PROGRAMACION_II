"""
Programa de manejo de fracciones .
ahora Franz
1.0 03/03/2026
"""
from fraccion import Fraccion

# Crea los objetos Fraccion
f1 = Fraccion(1, 4)
f2 = Fraccion(4, 3)
f3 = Fraccion(4, 1)
f4 = Fraccion(30, 20)

# Imprime cada fraccion
print("f1 =", f1)
print("f2 =", f2)

# imprime resultado de operaciones
s = f1 + f2 
print(" suma =" , s)
r = f1 - f2
print(" resta =", r)

# Inciso 1: Multiplicación (*)
print(" multiplicacion =", f1 * f2)

# Inciso 2: División (/)
print(" division =", f1 / f2)

# Inciso 3: Igualdad (==)
print(" ¿f1 == f2? =", f1 == f2)

# Inciso 4: Convertir a decimal
print(" f1 a decimal =", f1.convertirADecimal())

# Inciso 5: Verificar si es inverso
print(" ¿f1 es inverso de f3? =", f1.esInverso(f3))

# Inciso 6: Parsear String a Fraccion
f_parsed = Fraccion.parseFraccion("-9/5")
print(" fraccion paseada  =", f_parsed)

# Inciso 7: Simplificar fracción
print(" f4 simplificada =", f4.simplifica())