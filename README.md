#     Dalibe

# Library contains
- [x] [CfgLoader](#cfgloader)
- [x] [Nargs](#nargs)
- [x] [ColoredMessage](#coloredmessage)
- [x] [Parce](#parce)
- [x] [Times](#times)

# Planned
- [ ] idk it is perfect for me just for now

# Requirements
- [JDK 17](https://www.oracle.com/uk/java/technologies/downloads/) or higher
- Extremely recommended using terminal that supports ANSI escape chars

# Description
Every module installation parts are equal. General installation guide is [here](#instructions)
## CfgLoader
This module allows you to read data from the config file in a very convenient way, taking into account their necessity.
### Usage
First, you need to create a CfgLoader object file by specifying in the constructor the `name of the config file`, an `array of required data strings` and an `array of optional data strings`, e.g.
```Java
CfgLoader cfgLoader = new CfgLoader(
        "ConfigExample.txt", new String[]{"name", "age"}, new String[]{"gender"});
```
Second, cfgLoader should initialize config file with `.load()` method. It returns boolean value, true if all ok, and false if
- Config file contains duplicate required keys (e.g. "name=John" and "name=Peter")
- Config file not contains required key's value (e.g. "name=" or just no name key in config)
- I/O exception


You can track any error while initializing(if `.load()` returned false) using cfgLoader's attribute `stderr` or warnings in `stdwarn`

Useful way to init config is
```Java
if (cfgLoader.load()) 
    System.out.println("All OK");
else 
    System.out.println(cfgLoader.stderr);
System.out.println(cfgLoader.stdwarn);
```
Attributes `stderr` and `stdwarn` will be empty ("") if cfgLoader has no errors or warnings.

Then you can read `requirement` (`name` and `age` as in example above) values from config. Using if for example
```Java
String userName = cfgLoader.getCfgValue("name");
int userAge = Integer.parseInt(cfgLoader.getCfgValue("age"));
```
Of course, this is only just an example. In any java projects you should use more elaborate constructions (e.g. try).

`getCfgValue` can't return `null` in required keys if `.load()` returned true, but for extra keys (`gender` e.g. as above) it can be `null` if config file specifies empty value ("gender=")

```Java
String userName = cfgLoader.getCfgValue("gender"); // can be null
```

You can mix required and extra keys in `CfgLoader`'s constructor  by passing `null` as String[], e.g.
```Java
CfgLoader cfgLoader = new CfgLoader(
        "ConfigExample.txt", null, new String[]{"gender"});
```
or
```Java
CfgLoader cfgLoader = new CfgLoader(
        "ConfigExample.txt", new String[]{"name", "age"}, null);
```

You can get config's file name using cfgLoader's `currentConfig` attribute.

## Nargs
Nargs is an analogue from C `getopt.h` (similar usage).
### Usage
First, you need to create object from `Nargs` and declare String var, e.g.
```Java
Nargs nargs = new Nargs(args, "<a><b>:"); // in terminal, we use:   java -jar program.jar -a -b 12
String opt;
```
We are using `regex` string to set arg keys, but unlike C, you can set long arg keys, like `--force` or `--no`

Nargs automatically adds one `-` symbol for each arg key.

`:` symbol means(like in `getopt.h`) that this arg key must contain option(value).

In example above we used `<a><b>:` regex, it means:
- `-a` flag (not contain any value)
- `-b` value (must contain value)

Then, you can use while loop to get values from `nargs`, e.g.
```Java
while ((opt = nargs.getOpt()) != null){
            switch (opt){
                case "a" -> System.out.println("a flag");
                case "b" -> System.out.println("b value is " + nargs.optionArg);
            }
        }
```
If the `.getOpt()` method returns `null`, it means that all arguments have been read. Else it returns argument key, and then we can get its value from `.optionArg` attribute in `nargs`. It is very convenient using `switch` construction.

## ColoredMessage
[![N|Solid](https://github.com/0xDABE/Dalibe/blob/main/Screenshot_1.png?raw=true)](https://github.com/0xDABE/Dalibe/blob/main/Screenshot_1.png?raw=true)
This module gives you opportunity to print colourful text (using ANSI escape chars)
### Usage
Just use static `ColoredMessage`.`<color>` methods to print text. Each color has 4 methods (green for example):
- `.blue(String)` prints colored text
- `.blue(String, boolean)` prints colored text if boolean is true, else prints not colored text
- `.blueLn(String)` prints colored text with "\n" in the end
- `.blueLn(String, boolean)`prints colored text with "\n" in the end if boolean is true, else prints not colored text with "\n" in the end
## Parce
## Times


# Instructions



