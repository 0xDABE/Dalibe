#     Dalibe

# Library contains
- [x] [CfgLoader](#cfgloader)
- [x] [Nargs]()
- [x] [ColoredMessage]()
- [x] [Parce]()
- [x] [Times]()

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
Second, cfgLoader should initialize config file with `.load` method. It returns boolean value, true if all ok, and false if
- Config file contains duplicate required keys (e.g. "name=John" and "name=Peter")
- Config file not contains required key's value (e.g. "name=" or just no name key in config)
- I/O exception


You can track any error while initializing(if `.load` returned false) using cfgLoader's attribute `stderr` or warnings in `stdwarn`
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

`getCfgValue` can't return `null` in required keys if `.load` returned true, but for extra keys (`gender` e.g. as above) it can be `null` if config file specifies empty value ("gender=")

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
## ColoredMessage
## Parce
## Times


# Instructions



