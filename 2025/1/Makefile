INPUTS=input.txt

.PHONY: test $(INPUTS)
test: Day1.class $(INPUTS)
	java -cp "$(SCALA_HOME)/lib/scala-library.jar:." Day1 $(INPUTS)

Day1.class: Day1.scala
	scalac -deprecation Day1.scala
