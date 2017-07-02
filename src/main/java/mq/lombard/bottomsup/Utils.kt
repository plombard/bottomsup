package mq.lombard.bottomsup

import mq.lombard.bottomsup.bean.BeerItem
import mq.lombard.bottomsup.bean.BeerStyle
import mq.lombard.bottomsup.thirdparty.Beer

/** @author Pascal Lombard
 */
fun Float.alcoholToStyle(): BeerStyle = when {
  this < 6 -> BeerStyle.MILD
  this > 7.2 -> BeerStyle.STRONG
  else -> BeerStyle.MEDIUM
}

fun Beer.toBeerItem(): BeerItem = BeerItem(this.name, this.description, this
    .alcohol.alcoholToStyle())

