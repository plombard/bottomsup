package mq.lombard.bottomsup

import mq.lombard.bottomsup.bean.BeerItem
import mq.lombard.bottomsup.thirdparty.Beer

/** @author Pascal Lombard
 */
fun Beer.toBeerItem() = BeerItem(
    this.name, this.description, Utils.alcoholToStyle(this.alcohol))


