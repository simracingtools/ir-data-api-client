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

Main changes made by iRacing occur withing a new season rollout.

Starting in March 2023 this project switches versioning coupled to iRacing's seasoning.
A version respecting changes made in iRacing's season 2023/2 will be v23.2.0. Fixes within a seasion 
will be 23.2.1, 23.2.2 and further on.


## Known endpoint restrictions

https://members-ng.iracing.com/data/results/lap_chart_data - does not work for league sessions

https://members-ng.iracing.com/data/results/lap_data - does work for league sessions

https://members-ng.iracing.com/data/results/season_results - does not work for league sessions


## Hints

Although all current occurring fields are mapped there is no guarantee
additional fields will appear without warning. If this is the case please
open an issue stating the exception stacktrace and the response logged while having `setLogJsonResponse(true)` in `IrDataClient`.


Always be aware that not all fields in a DTO are filled. Some DTO's are
used as subtypes more than one other DTO on different detail grade. Do ` null` checks when using DTO field content. 

