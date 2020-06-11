NTFS drives were mounted only in read only mode

To list the disks

> sudo fdisk -l 

To fix NTFS mount in ubuntu

> sudo ntfsfix <mount_name>
e.g.
> sudo ntfsfix /dev/sda5