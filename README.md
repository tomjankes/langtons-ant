# Langton's ant simulation

Contains three modules:

* domain (contains base logic of langton's ant)

* console (displays langton's ant on the console)

* swing (displays langton's ant live on swing component)

To run applications:

* console: ```./gradlew :console:run```

* swing: ```./gradlew :swing:run```

In classes with main method you can find some properties to tweak (number of iterations, speed of ant etc.)

Inspired by https://rosettacode.org/wiki/Langton%27s_ant#Java

Example output:

![Image of example program output](https://raw.githubusercontent.com/tomjankes/langtons-ant/master/example-output.png)
