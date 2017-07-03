package mq.lombard.bottomsup.actor

import mq.lombard.bottomsup.bean.Glass

/** @author Pascal Lombard
 */
class Drinker @JvmOverloads constructor(val name: String = "",
                                        val organization: String = "",
                                        var glass: Glass? = null,
                                        var paid: Int = 0,
                                        var drank: MutableList<String> = mutableListOf(),
                                        var drinkStrategy: (String) -> String = memberDrinkStrategy) {

  fun drink(): String {
    this.glass!!.toRefill = true
    drank.add(glass!!.beerName)
    return drinkStrategy(name)
  }

  fun pay(drinks: Int) {
    this.paid += drinks
  }

  fun fillGlass() {
    this.glass!!.toRefill = false
  }
}
