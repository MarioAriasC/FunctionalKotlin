package com.packtpub.functionalkotlin.chapter01.basics

class VeryBasic

val basic = VeryBasic()

class BlueberryCupcake {
	val flavour = "Blueberry"
}

class AlmondCupcake {
	val flavour = "Almond"
}

abstract class BakeryGood(val flavour: Flavour) {

	init {
		//println("Preparing a new bakery good")
	}

	fun eat(): String {
		return "nom, nom, nom... delicious $flavour ${name()}"
	}

	abstract fun name(): String
}

interface Bakeable {

	fun bake(): String {
		return "is hot here, isn't??"
	}


}

class Cupcake(flavour: String) : BakeryGood(flavour), Bakeable {

	override fun name(): String {
		return "cupcake"
	}

	companion object {
		fun almond(): Cupcake {
			return Cupcake("almond")
		}

		fun cheese(): Cupcake {
			return Cupcake("cheese")
		}
	}

}

class Biscuit(flavour: String) : BakeryGood(flavour), Bakeable {
	override fun name(): String {
		return "biscuit"
	}
}

@Tasty
interface Fried {
	fun fry(): String
}

open class Donut(flavour: String, val topping: String) : BakeryGood(flavour), Fried {
	override fun fry(): String {
		return "*swimming on oil*"
	}

	override fun name(): String {
		return "donut with $topping topping"
	}
}

class Churro() : Donut("caramel", "sugar") {
	override fun fry(): String {
		return super.fry()
	}
}

open class Roll(flavour: String) : BakeryGood(flavour), Bakeable {
	override fun name(): String {
		return "roll"
	}
}

@Tasty
class CinnamonRoll : Roll("Cinnamon")


class Customer(val name: String) {
	fun eats(food: BakeryGood) {
		//val p = println("$name is eating... ${food.eat()}")
	}
}

interface Machine<T> {
	fun process(product: T)
}

typealias Oven = Machine<Bakeable>

typealias Flavour = String

typealias OvenTray = List<Bakeable>

typealias CupcakeFactory = Cupcake.Companion


@Tasty(false)
object ElectricOven : Oven {
	override fun process(product: Bakeable) {
		//println(product.bake())
	}
}

class Outer {
	val internal = object {
		val property = ""
	}
}

fun eat(cupcake: Cupcake?) {

}

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Tasty(val tasty: Boolean = true)


data class Item(val product: BakeryGood, val unitPrice: Double, val quantity: Int)

interface Exotic {
	fun isExotic(): Boolean
}

enum class Flour : Exotic {
	WHEAT {
		override fun isGlutenFree(): Boolean {
			return false
		}

		override fun isExotic(): Boolean {
			return false
		}
	},

	CORN {
		override fun isGlutenFree(): Boolean {
			return true
		}

		override fun isExotic(): Boolean {
			return false
		}
	},

	CASSAVA {
		override fun isGlutenFree(): Boolean {
			return true
		}

		override fun isExotic(): Boolean {
			return true
		}
	};

	abstract fun isGlutenFree(): Boolean
}

fun flourDescription(flour: Flour): String {
	return when(flour) {
		Flour.CASSAVA -> "A very exotic flavour"
		else -> "Boring"
	}
}

fun main(args: Array<String>) {


	val myCupcake = BlueberryCupcake()
//	//println("My cupcake has ${myCupcake.flavour} flavour")

	val mySecondCupcake = AlmondCupcake()
//	//println("My second cupcake has ${mySecondCupcake.flavour} flavour")

//	val myBlueberryCupcake: BakeryGood? = null
	val myBlueberryCupcake: BakeryGood = Cupcake("Blueberry")


	val myAlmondCupcake = CupcakeFactory.almond()
	val myCheeseCupcake = Cupcake.cheese()
//	val myCheeseCupcake = myAlmondCupcake.cheese()
	val myCaramelCupcake = Cupcake("Caramel")

	val factory: Cupcake.Companion = Cupcake


//	val anyGood = BakeryGood("Generic flavour")


//	println(myBlueberryCupcake!!.eat())

	val myDonut = Donut("Custard", "Powdered sugar")

//	//println(myDonut.eat())

	val mario = Customer("Mario")

	mario.eats(myDonut)

	val food: BakeryGood = object : BakeryGood("TEST_1") {
		override fun name(): String {
			return "TEST_2"
		}
	}

	mario.eats(food)

	val somethingFried = object : Fried {
		override fun fry(): String {
			return "TEST_3"
		}
	}

	ElectricOven.process(myAlmondCupcake)

	val expression = object {
		val property = ""

		fun method(): Int {
			//println("from an object expressions")
			return 42
		}
	}

	val i = "${expression.method()} ${expression.property}"

	/*val outer = Outer()
	outer.internal.property*/

	eat(myAlmondCupcake)
	eat(null)

	val cupcake: Cupcake = Cupcake.almond()
	val nullableCupcake: Cupcake? = Cupcake.cheese()

	cupcake.eat() // Happy days
	//nullableCupcake.eat() // Compilation error

	if (nullableCupcake != null) {
		nullableCupcake.eat()
	}

	if (nullableCupcake is Cupcake) {
		nullableCupcake.eat()
	}

	when (nullableCupcake) {
		is Cupcake -> nullableCupcake.eat()
	}

	nullableCupcake?.eat()

//	val result: String? = nullableCupcake?.eat()

//	val length: Int? = nullableCupcake?.eat()?.length

//	val result: String = nullableCupcake?.eat() ?: ""

//	val length: Int = nullableCupcake?.eat()?.length ?: 0

//	val result: String = nullableCupcake!!.eat()
//
//	val length: Int = nullableCupcake.eat().length


	val result = nullableCupcake?.eat() ?: throw RuntimeException()

//	val length = nullableCupcake?.eat()?.length ?: ""

	val length: Number = nullableCupcake?.eat()?.length ?: 0.0
	val dessert = Roll("Coconut") ?: CinnamonRoll()


	val basket = listOf(myAlmondCupcake, CinnamonRoll(), nullableCupcake)

	val unitMachine = object : Machine<Unit> {
		override fun process(product: Unit) {

		}

	}

	unitMachine.process(Unit)

	val anyMachine = object : Machine<Any> {
		override fun process(product: Any) {
			//println(product.toString())
		}
	}

	anyMachine.process(3)
	anyMachine.process("")
	anyMachine.process(myAlmondCupcake)
	anyMachine.process(nullableCupcake)
	anyMachine.process(Unit)
//	anyMachine.process(Nothing)


	fun nothing(n: Nothing) {

	}

	val x: Nothing? = null

	val nullList: List<Nothing?> = listOf(null)

	val myItem = Item(myAlmondCupcake, 0.40, 5)

	val mySecondItem = myItem.copy(product = myCaramelCupcake)

	val (prod, _, qty) = mySecondItem


//	nothing(null)

	val annotations: List<Annotation> = ElectricOven::class.annotations

	/*for (annotation in annotations) {
		when (annotation) {
			is Tasty -> //println("Is it tasty? ${annotation.tasty}")
			else -> //println(annotation)
		}
	}*/

	println("nom, nom, nom... delicious Blueberry bakery good")
}

