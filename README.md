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

which should hold your valid iRacing credentials.
For usage hints see 

`
class IrDataClientTest
`

## Currently implemented endpoints:

https://members-ng.iracing.com/auth

https://members-ng.iracing.com/data/member/get

https://members-ng.iracing.com/data/car/get

https://members-ng.iracing.com/data/car/assets

https://members-ng.iracing.com/data/league/get

https://members-ng.iracing.com/data/track/get

https://members-ng.iracing.com/data/carclass/get

https://members-ng.iracing.com/data/constants/divisions

https://members-ng.iracing.com/data/lookup/licenses

https://members-ng.iracing.com/data/stats/member_summary

https://members-ng.iracing.com/data/stats/member_yearly

https://members-ng.iracing.com/data/stats/member_career

https://members-ng.iracing.com/data/track/assets

https://members-ng.iracing.com/data/series/seasons

## Hints

Although all current occurring fields are mapped there is no guarantee
additional fields will appear without warning. If this is the case please
open an issue stating the request you made and the exception stacktrace
logged.

Always be aware that not all fields in a DTO are filled. Some DTO's are
used as subtypes more than one other DTO on different detail grade. Do ` null` checks when using DTO field content. 

