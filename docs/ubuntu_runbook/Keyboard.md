## End was stuck need to disable it permanently

### Get key codes

> sudo su

Then press the keys to get the keycodes 

> showkey -s

Then you will see two scan codes ( Press and release button codes )
For `End` key
```
0xe0 0x4f (press) 
0xe0 0xcf (release)
```
### Run script for every boot time
vi /etc/init.d/KeyboardFix.sh

```
#!/bin/sh

setkeycodes e04f 255
setkeycodes e0cf 255
```
chmod 755 /etc/init.d/KeyboardFix.sh

ln -s /etc/init.d/KeyboardFix.sh /etc/rc2.d/S95KeyboardFix

