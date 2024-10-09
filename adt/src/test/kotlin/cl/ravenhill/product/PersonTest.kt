package cl.ravenhill.product

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PersonTest : FreeSpec({
    "A person" - {
        "can be created" {
            with(Person("John", 30)) {
                name shouldBe "John"
                age shouldBe 30
            }
        }

        "can be compared" {
            val person1 = Person("John", 30)
            val person2 = Person("John", 30)
            person1 shouldBe person2
        }

        "can be copied" {
            val person1 = Person("John", 30)
            val person2 = person1.copy(name = "Jane")
            person1 shouldBe Person("John", 30)
            person2 shouldBe Person("Jane", 30)
        }

        "can be destructured" {
            val (name, age) = Person("John", 30)
            name shouldBe "John"
            age shouldBe 30
        }

        "can be converted to a string" {
            Person("John", 30).toString() shouldBe "Person(name=John, age=30)"
        }
    }
})