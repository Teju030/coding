After suspend mode of ubuntu
Wifi gets disabled while airplane mode gets ON which can not be disabled directly, only reboot options works

> sudo rfkill list all
```
1: phy0: Wireless LAN
Soft blocked: no
Hard blocked: yes
```

### solution 
> sudo nano /etc/systemd/system/hp-keycodes.service
```
[unit]
Description=HP keycodes fix

[Service]
Type=oneshot
Restart=no
RemainAfterExit=no
ExecStart=/usr/bin/setkeycodes e057 240 e058 240

[Install]
WantedBy=rescue.target
WantedBy=multi-user.target
WantedBy=graphical.target
```
Save and confirm the filename with ctrl-x, y.

$ sudo systemctl daemon-reload
$ sudo systemctl enable hp-keycodes.service
$ sudo reboot