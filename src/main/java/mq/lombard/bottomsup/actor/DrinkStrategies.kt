package mq.lombard.bottomsup.actor

/**
 * @author Pascal Lombard
 */

val memberDrinkStrategy = { name: String -> "Et glou, [$name] !" }
val leaderDrinkStrategy = { name: String ->
  "Et glou, [$name] ! (Mais c'était meilleur à DevoxxBE)"
}