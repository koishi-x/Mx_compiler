# Change the src to the path of your java source files
JAVA_SRC = $(shell find src -name '*.java')
# Change this to the path of your antlr jar
ANTLR_JAR = /usr/share/java/antlr-4.11.1-complete.jar
#ANTLR_JAR = /home/xzq/project/Mx_compiler/src/antlr-4.11.1-complete.jar

.PHONY: all
all: Compiler

.PHONY: Compiler
Compiler: $(JAVA_SRC)
	javac -d bin $(JAVA_SRC) -cp $(ANTLR_JAR) -encoding UTF-8

.PHONY: clean
clean:
	find bin -name '*.class' -or -name '*.jar' | xargs rm -f