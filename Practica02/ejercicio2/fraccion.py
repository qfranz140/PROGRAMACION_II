"""
La Clase Fraccion .
ahora franz
1.0 03/03/2026
"""
class Fraccion :
	def __init__(self, a, b):
		self.__numerador = a
		self.__denominador = b

	def __add__(self, o):
		a = self.__numerador * o.__denominador + \
			self.__denominador * o.__numerador
		b = self.__denominador * o.__denominador
		return Fraccion(a, b)

	def __sub__(self, o):
		c = Fraccion(0, 1)
		c.__numerador = self.__numerador * o.__denominador - \
			self.__denominador * o.__numerador
		c.__denominador = self.__denominador * o.__denominador
		return c

	def __str__(self):
		return " {}/{} ".format(self.__numerador, self.__denominador)

	# Inciso 1: Multiplica dos fracciones usando el operador *
	def __mul__(self, o):
		a = self.__numerador * o.__numerador
		b = self.__denominador * o.__denominador
		return Fraccion(a, b)

	# Inciso 2: Divide dos fracciones usando el operador /
	def __truediv__(self, o):
		a = self.__numerador * o.__denominador
		b = self.__denominador * o.__numerador
		return Fraccion(a, b)

	# Inciso 3: Compara si dos fracciones son iguales usando ==
	def __eq__(self, o):
		if not isinstance(o, Fraccion):
			return False
		return self.__numerador * o.__denominador == self.__denominador * o.__numerador

	# Inciso 4: Convierte la fracción a decimal validando división entre cero
	def convertirADecimal(self):
		if self.__denominador == 0:
			print("Error: División entre cero")
			return None
		return self.__numerador / self.__denominador

	# Inciso 5: Comprueba si esta fracción es inversa de otra usando el operador *
	def esInverso(self, o):
		producto = self * o
		return producto.convertirADecimal() == 1.0

	# Inciso 6: Convierte una cadena "a/b" en un objeto Fraccion
	@staticmethod
	def parseFraccion(cadena):
		partes = cadena.strip().split('/')
		n = int(partes[0])
		d = int(partes[1])
		return Fraccion(n, d)

	# Inciso 7: Retorna una nueva Fraccion simplificada
	def simplifica(self):
		import math
		mcd = math.gcd(self.__numerador, self.__denominador)
		return Fraccion(self.__numerador // mcd, self.__denominador // mcd)