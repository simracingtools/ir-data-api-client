# Java client for the iRacing data api and the use with SpringBoot

iRacing has released it's data api. The so far existing documentation can be found here:
https://forums.iracing.com/discussion/15068/general-availability-of-data-api/p1

The client is configured by the spring properties

`
irdataapi.user=
`

`
irdataapi.password=
`

which should be hold your valid iRacing credentials.

## Currently implemented endpoints:

https://members-ng.iracing.com/auth

https://members-ng.iracing.com/data/member/get

https://members-ng.iracing.com/data/car/get

