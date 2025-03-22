### \[Let's Do Addon\] Compat

This mod adds compatibility between the Let's Do mods and a plethora of mods, so you don't have to do it

Compatibility currently (as of version 2.1.0) includes:
* All Let's Do Farm&Charm based mods (Farm&Charm, Candlelight, Brewery, Bakery) and others (Vinery, Beachparty...)
* All Farm&Charm unofficial addons (CornExpansion…)
* Farmer's Delight / Farmer's Delight Refabricated
* All Farmer's Delight addons
* Thirst mods compatibility (Legendary Survival Overhaul, Thirst was Taken, Dehydration...)
* Various Create Millstone and Mixer recipes

Plans:
* Any of YOUR suggestions ! Feel free to drop in the discord or github issues

The mod also features a light API for developers to add compatibility with all supported thirst mods at once, in a loader-agnostic way (you can use it forge-only, fabric-only or with both loader supported):
```java
ThirstCompatHelper#registerDrinkThirst(String itemName, int thirst, float quench);
// OR
ThirstCompatHelper#registerFoodThirst(String itemName, int thirst, float quench);
```
