# Towers

Playing around at writing a tower defence game. Trying a slightly new concept of having modular towers, called bunkers. A bunker can have different modules installed to alter its capabilities. Currently bunkers support a tracking device and a weapon.

Tracking devices handle target selection and relay targets to the weapon, which fires at them.

![Screenshot](https://github.com/qwerky/Towers/raw/master/screenshot.png)

### TODO

 - Review and finish tech tree
 - Weapon balancing
 - Better UI - more stuff in the panels
 - Ammo storage module
  - weapons consume ammo from storage
  - when storage is empty long cooldown to reload
 - Multiple levels
 - Better art
 - Sounds
 - Help page details

#### 20 May 2013

 - Added more heavy weapons and trackers
 - Started on help page

#### 17 May 2013

 - Bunker space and power usage! You can now only put in what fits and what you can power
 - Added info (power, space, range, dps) to bunker panel
 - Added militia; a crazed bunch of locals armed with whatever they can lay their hands on
 - Fixed blast projectiles double hitting creeps

#### 16 May 2013

 - Added display of coming waves, its a bit crappy though
 - Projectiles now have blast area
 - Added napalm cannon with a persistent blast area
 - Refactored AnimatedCreep so each instance doesn't load its own images
 
##### 14 May 2013

 - Added flame thrower
 - Added animated creeps

##### 10 May 2013

 - Added more creeps and waves
 - Added new nearest to base tracker
 - Added sell button for bunkers
 - Added help dialog

##### 8 May 2013

 - Further fleshed out out tech tree

##### 7 May 2013

 - Added Vector2D class to handle position and movement of things
 - Create Light MG arms which fires in bursts and leads targets

##### 3 May 2013

 - Health bars for creeps
 - New medium range radar tracker
 - Descriptions for arms and trackers

##### 30 April 2013

 - Double buffered display
 - Added tech tree and ability to upgrade the weapons and tracking system in a bunker

##### 29 April 2013

 - Ability to build bunkers

##### 26 April 2013

 - Added creep health and projectile damage
 - Killing creeps now gives money
 - Added cruise launcher which fires really cool seeking missiles!
 
 ##### 25 April 2013

Got a reasonably good start with levels, creeps, bunkers and stuff. UI is basic but fine for now.
 
 