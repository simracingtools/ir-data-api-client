# ir-data-api-client changelog

Changelog of ir-data-api-client.

## v2.1.1 (2022-06-09)





### Bug Fixes

-  New fields added (grid/heat_spec) ([b14d4](https://github.com/simracingtools/ir-data-api-client/commit/b14d4e5a31f4d4d) Robert Bausdorf)  


### Other changes

**[maven-release-plugin] prepare release v2.1.1**


[0cd96](https://github.com/simracingtools/ir-data-api-client/commit/0cd96319e61834b) Robert Bausdorf *2022-06-09 09:48:35*

**[maven-release-plugin] prepare for next development iteration**


[8aef1](https://github.com/simracingtools/ir-data-api-client/commit/8aef1e7323c5fa4) Robert Bausdorf *2022-06-08 22:50:59*


## v2.1.0 (2022-06-08)



### Features

-  Constant endpoints for categories and event types added ([a02be](https://github.com/simracingtools/ir-data-api-client/commit/a02bef63444c0e8) Robert Bausdorf)  


### Bug Fixes

-  Endpoint cust_league_sessions replces membersite endpoint ([ec38b](https://github.com/simracingtools/ir-data-api-client/commit/ec38b8600a4b272) Robert Bausdorf)  


### Other changes

**[maven-release-plugin] prepare release v2.1.0**


[b2a12](https://github.com/simracingtools/ir-data-api-client/commit/b2a129afa8850a5) Robert Bausdorf *2022-06-08 22:50:56*

**[maven-release-plugin] prepare for next development iteration**


[75cfc](https://github.com/simracingtools/ir-data-api-client/commit/75cfc479c239c4f) Robert Bausdorf *2022-06-07 21:42:02*


## v2.0.0 (2022-06-07)

### Breaking changes

-  getTeamMembers changed to use data API ([579cd](https://github.com/simracingtools/ir-data-api-client/commit/579cdf6106a6033) Robert Bausdorf)  


### Features

-  getTeamMembers changed to use data API ([579cd](https://github.com/simracingtools/ir-data-api-client/commit/579cdf6106a6033) Robert Bausdorf)  
-  Hash password according to 2022 season 3 release ([34641](https://github.com/simracingtools/ir-data-api-client/commit/3464112a3906741) Robert Bausdorf)  


### Bug Fixes

-  2022 Season 3 changes ([a9499](https://github.com/simracingtools/ir-data-api-client/commit/a9499f85d592128) Robert Bausdorf)  


### Other changes

**[maven-release-plugin] prepare release v2.0.0**


[30360](https://github.com/simracingtools/ir-data-api-client/commit/30360a5049e9461) Robert Bausdorf *2022-06-07 21:41:59*

**[maven-release-plugin] prepare for next development iteration**


[1eab2](https://github.com/simracingtools/ir-data-api-client/commit/1eab268a921fbbe) Robert Bausdorf *2022-05-09 20:41:05*


## v1.1.0 (2022-05-09)



### Features

-  Endpoints for team members and league sessions added (using old website) ([69dce](https://github.com/simracingtools/ir-data-api-client/commit/69dcefbe6f7e2cd) robert)  


### Bug Fixes

-  TrackMap was missing tracks with same sku ([df741](https://github.com/simracingtools/ir-data-api-client/commit/df7411712e42f83) robert)  


### Other changes

**[maven-release-plugin] prepare release v1.1.0**


[0d508](https://github.com/simracingtools/ir-data-api-client/commit/0d50889eed29afc) Robert Bausdorf *2022-05-09 20:41:01*

**[maven-release-plugin] prepare for next development iteration**


[11de1](https://github.com/simracingtools/ir-data-api-client/commit/11de1714ff44bfe) Robert Bausdorf *2022-04-13 16:48:08*


## v1.0.0 (2022-04-13)



### Features

-  all endpoints supported ([030cf](https://github.com/simracingtools/ir-data-api-client/commit/030cf47ee4d6f8b) Robert Bausdorf)  
-  member/info endpoint added ([27c1e](https://github.com/simracingtools/ir-data-api-client/commit/27c1e06307040e9) Robert Bausdorf)  
-  lookup/get endpoint added ([79b1c](https://github.com/simracingtools/ir-data-api-client/commit/79b1c2f8458c356) robert)  
-  Provide ability to cache API results in json file ([b7679](https://github.com/simracingtools/ir-data-api-client/commit/b7679621bbb31ac) robert)  


### Bug Fixes

-  Code cleanup ([a5fd4](https://github.com/simracingtools/ir-data-api-client/commit/a5fd4a8a1d842e8) Robert Bausdorf)  
-  Wrong checking for chunk rows ([c1cd0](https://github.com/simracingtools/ir-data-api-client/commit/c1cd0e695f2f776) Robert Bausdorf)  
-  Reading from file used wrong types due to Java type erasure ([3440f](https://github.com/simracingtools/ir-data-api-client/commit/3440fc72852dfa1) robert)  


### Other changes

**[maven-release-plugin] prepare release v1.0.0**


[b0c9a](https://github.com/simracingtools/ir-data-api-client/commit/b0c9a188e327138) Robert Bausdorf *2022-04-13 16:48:04*

**Merge branch 'master' into develop**


[df979](https://github.com/simracingtools/ir-data-api-client/commit/df979a843ef13dc) robert *2022-04-12 21:50:27*

**[maven-release-plugin] prepare for next development iteration**


[f9deb](https://github.com/simracingtools/ir-data-api-client/commit/f9deb43a815ed2f) Robert Bausdorf *2022-04-12 21:47:22*

**[maven-release-plugin] prepare for next development iteration**


[1bdf8](https://github.com/simracingtools/ir-data-api-client/commit/1bdf883c4238a81) Robert Bausdorf *2022-04-10 13:31:47*


## v0.10.1 (2022-04-12)







### Other changes

**[maven-release-plugin] prepare release v0.10.1**


[370b0](https://github.com/simracingtools/ir-data-api-client/commit/370b0d9ce292aa0) Robert Bausdorf *2022-04-12 21:47:18*

**Generic caching (#1)**

* feat: Provide ability to cache API results in json file 
* fix: Reading from file used wrong types due to Java type erasure 

[a4787](https://github.com/simracingtools/ir-data-api-client/commit/a4787f2b5f537bd) Robert Bausdorf *2022-04-12 21:40:54*


## v0.10.0 (2022-04-10)



### Features

-  event_log endoint added ([ec853](https://github.com/simracingtools/ir-data-api-client/commit/ec8531b6ccb4b46) Robert Bausdorf)  
-  More filtering tools for cars / tracks ([21811](https://github.com/simracingtools/ir-data-api-client/commit/218119cef7939da) Robert Bausdorf)  


### Bug Fixes

-  added starting_position_in_class to MemberSessionResultDto ([7eb85](https://github.com/simracingtools/ir-data-api-client/commit/7eb8580b4ff2671) Robert Bausdorf)  


### Other changes

**[maven-release-plugin] prepare release v0.10.0**


[f0ff7](https://github.com/simracingtools/ir-data-api-client/commit/f0ff7e68a38632b) Robert Bausdorf *2022-04-10 13:31:44*

**[maven-release-plugin] prepare for next development iteration**


[dd3b1](https://github.com/simracingtools/ir-data-api-client/commit/dd3b1e0c8707335) Robert Bausdorf *2022-04-01 20:55:45*


## v0.9.1 (2022-04-01)





### Bug Fixes

-  Old cookies prevented re-authorization ([03113](https://github.com/simracingtools/ir-data-api-client/commit/03113abb38f6e0e) robert)  


### Other changes

**[maven-release-plugin] prepare release v0.9.1**


[dadf4](https://github.com/simracingtools/ir-data-api-client/commit/dadf46c54093602) Robert Bausdorf *2022-04-01 20:55:42*

**[maven-release-plugin] prepare for next development iteration**


[82db6](https://github.com/simracingtools/ir-data-api-client/commit/82db6ed093e436a) Robert Bausdorf *2022-03-30 15:29:43*


## v0.9.0 (2022-03-30)



### Features

-  season_results endpoint added ([2c860](https://github.com/simracingtools/ir-data-api-client/commit/2c860ec2d55cf64) Robert Bausdorf)  
-  lap_data endpoint added ([380f3](https://github.com/simracingtools/ir-data-api-client/commit/380f3a56c3bb1a1) Robert Bausdorf)  
-  lap_chart_data endpoint added ([d5da5](https://github.com/simracingtools/ir-data-api-client/commit/d5da57c13298639) Robert Bausdorf)  
-  Tool for finding a series by partly name ([79baf](https://github.com/simracingtools/ir-data-api-client/commit/79bafa3411ee4f8) robert)  
-  Tool for getting cars in a class list ([08abb](https://github.com/simracingtools/ir-data-api-client/commit/08abb3045edd995) robert)  
-  Tooling for season data ([bbd56](https://github.com/simracingtools/ir-data-api-client/commit/bbd568d92182be1) robert)  


### Bug Fixes

-  Result data fixed for team sessions ([7bb47](https://github.com/simracingtools/ir-data-api-client/commit/7bb4714f206c242) Robert Bausdorf)  


### Other changes

**[maven-release-plugin] prepare release v0.9.0**


[46342](https://github.com/simracingtools/ir-data-api-client/commit/46342dda40ebcaf) Robert Bausdorf *2022-03-30 15:29:39*

**Changelog v0.8.0**


[1fe7e](https://github.com/simracingtools/ir-data-api-client/commit/1fe7ec3433c9c1e) Robert Bausdorf *2022-03-25 18:21:26*

**[maven-release-plugin] prepare for next development iteration**


[80f61](https://github.com/simracingtools/ir-data-api-client/commit/80f61b6548250dd) Robert Bausdorf *2022-03-25 18:13:25*


## v0.8.0 (2022-03-25)





### Bug Fixes

-  Test fixes ([e9085](https://github.com/simracingtools/ir-data-api-client/commit/e90851f20877216) Robert Bausdorf)  
-  License info added ([fadce](https://github.com/simracingtools/ir-data-api-client/commit/fadcefc7234f140) Robert Bausdorf)  


### Other changes

**[maven-release-plugin] prepare release v0.8.0**


[09dff](https://github.com/simracingtools/ir-data-api-client/commit/09dffb79e0ce225) Robert Bausdorf *2022-03-25 18:13:21*

**Changelog added**


[439fe](https://github.com/simracingtools/ir-data-api-client/commit/439fe7cd81b143f) Robert Bausdorf *2022-03-25 18:11:12*

**Cache for stock data (tracks, cars, license groups, divisions) added.**

* Some tooling support on stock data. 

[2a653](https://github.com/simracingtools/ir-data-api-client/commit/2a653a464461e1b) robert *2022-03-25 17:07:16*

**Object Mapper for convenience**


[c0533](https://github.com/simracingtools/ir-data-api-client/commit/c0533141eeb6eea) robert *2022-03-25 15:52:42*

**Dates / times mapped to**


[d8a71](https://github.com/simracingtools/ir-data-api-client/commit/d8a710fa90bd4f4) robert *2022-03-25 15:50:48*

**Switched to JsonProperty annotations.**

* Dto getter/setter are now strictly camelCase. 

[6f037](https://github.com/simracingtools/ir-data-api-client/commit/6f03727a41f569a) robert *2022-03-25 13:25:06*

**[maven-release-plugin] prepare for next development iteration**


[4f8b8](https://github.com/simracingtools/ir-data-api-client/commit/4f8b8e14d27b37e) Robert Bausdorf *2022-03-24 17:19:19*


## v0.7.0 (2022-03-24)







### Other changes

**[maven-release-plugin] prepare release v0.7.0**


[f04f4](https://github.com/simracingtools/ir-data-api-client/commit/f04f4b5ec2cb63e) Robert Bausdorf *2022-03-24 17:19:14*

**Possibility to log plain json responses from iRacing.**


[9dedb](https://github.com/simracingtools/ir-data-api-client/commit/9dedb15bea439bf) robert *2022-03-24 17:02:07*

**Hints added**


[a316b](https://github.com/simracingtools/ir-data-api-client/commit/a316b62e521f13b) robert *2022-03-24 16:33:44*

**Sonarcube issues**


[d11d9](https://github.com/simracingtools/ir-data-api-client/commit/d11d9730c8f0fbe) robert *2022-03-24 16:25:28*

**Seasons endpoint added**


[1b6a5](https://github.com/simracingtools/ir-data-api-client/commit/1b6a551f5622a8b) robert *2022-03-24 16:12:23*

**Member career endpoint added**


[da06a](https://github.com/simracingtools/ir-data-api-client/commit/da06aa7042c8894) robert *2022-03-24 14:44:36*

**Member recent races endpoint added**


[d8adf](https://github.com/simracingtools/ir-data-api-client/commit/d8adf8dc47fdc7d) robert *2022-03-24 14:30:00*

**Track assets endpoint added**


[4e38a](https://github.com/simracingtools/ir-data-api-client/commit/4e38a7d6504bbc6) robert *2022-03-24 13:33:26*

**License file header added**


[31fc7](https://github.com/simracingtools/ir-data-api-client/commit/31fc77da459d0f8) robert *2022-03-24 11:58:57*

**Member yearly stats endpoint added**


[c81ec](https://github.com/simracingtools/ir-data-api-client/commit/c81ec7081be7047) robert *2022-03-24 11:57:36*

**Member summary endpoint added**


[60a7c](https://github.com/simracingtools/ir-data-api-client/commit/60a7c1586ac80a9) robert *2022-03-24 11:39:50*

**Licenses endpoint added**


[2ba33](https://github.com/simracingtools/ir-data-api-client/commit/2ba33ca5f0b8df7) robert *2022-03-24 11:20:52*

**Divisions endpoint added**


[0b342](https://github.com/simracingtools/ir-data-api-client/commit/0b342a995cf6e83) robert *2022-03-24 11:09:08*

**Car class endpoint added**


[16cd6](https://github.com/simracingtools/ir-data-api-client/commit/16cd643645d6b39) robert *2022-03-24 10:57:13*

**License info added**


[d3aca](https://github.com/simracingtools/ir-data-api-client/commit/d3aca2e20fc5b93) Robert Bausdorf *2022-03-14 18:45:37*

**[maven-release-plugin] prepare for next development iteration**


[fedc0](https://github.com/simracingtools/ir-data-api-client/commit/fedc0c8f96aa52c) Robert Bausdorf *2022-03-14 18:01:35*


## ir-data-api-client-0.5.0 (2022-03-14)







### Other changes

**[maven-release-plugin] prepare release ir-data-api-client-0.5.0**


[a9b22](https://github.com/simracingtools/ir-data-api-client/commit/a9b2263d7bcbff8) Robert Bausdorf *2022-03-14 18:01:32*

**New endpoints added**


[c51a6](https://github.com/simracingtools/ir-data-api-client/commit/c51a681f170e504) Robert Bausdorf *2022-03-14 18:00:23*

**[maven-release-plugin] prepare for next development iteration**


[95a97](https://github.com/simracingtools/ir-data-api-client/commit/95a976e5184b43e) Robert Bausdorf *2022-03-14 15:37:25*


## ir-data-api-client-0.1.2 (2022-03-14)







### Other changes

**[maven-release-plugin] prepare release ir-data-api-client-0.1.2**


[0e46e](https://github.com/simracingtools/ir-data-api-client/commit/0e46e2264b6bc85) Robert Bausdorf *2022-03-14 15:37:21*

**Added metadata required by sonatype**


[7b694](https://github.com/simracingtools/ir-data-api-client/commit/7b694109c73c499) Robert Bausdorf *2022-03-14 15:36:21*

**[maven-release-plugin] rollback the release of ir-data-api-client-0.1.1**


[60e4e](https://github.com/simracingtools/ir-data-api-client/commit/60e4e5412486e2b) Robert Bausdorf *2022-03-14 15:31:12*

**[maven-release-plugin] prepare for next development iteration**


[02437](https://github.com/simracingtools/ir-data-api-client/commit/024370c1ab0a4f2) Robert Bausdorf *2022-03-14 15:28:34*


## ir-data-api-client-0.1.1 (2022-03-14)







### Other changes

**[maven-release-plugin] prepare release ir-data-api-client-0.1.1**


[2f5b8](https://github.com/simracingtools/ir-data-api-client/commit/2f5b8d3ca59a8da) Robert Bausdorf *2022-03-14 15:28:30*

**[maven-release-plugin] rollback the release of ir-data-api-client-0.1.0**


[655e2](https://github.com/simracingtools/ir-data-api-client/commit/655e2c88c83ab64) Robert Bausdorf *2022-03-14 15:28:03*

**[maven-release-plugin] prepare release ir-data-api-client-0.1.0**


[78dbb](https://github.com/simracingtools/ir-data-api-client/commit/78dbb251a2f4a3d) Robert Bausdorf *2022-03-14 15:27:41*

**[maven-release-plugin] rollback the release of ir-data-api-client-0.1.0**


[89183](https://github.com/simracingtools/ir-data-api-client/commit/891834325db48b5) Robert Bausdorf *2022-03-14 15:27:21*

**Added metadata required by sonatype**


[6fecd](https://github.com/simracingtools/ir-data-api-client/commit/6fecd5a0b42e165) Robert Bausdorf *2022-03-14 15:26:38*

**[maven-release-plugin] prepare for next development iteration**


[c8a8b](https://github.com/simracingtools/ir-data-api-client/commit/c8a8b50e1877a33) Robert Bausdorf *2022-03-14 15:14:08*


## ir-data-api-client-0.1.0 (2022-03-14)







### Other changes

**[maven-release-plugin] prepare release ir-data-api-client-0.1.0**


[afd7f](https://github.com/simracingtools/ir-data-api-client/commit/afd7f39f52b5ece) Robert Bausdorf *2022-03-14 15:14:05*

**Release and deployment configurations**


[5e809](https://github.com/simracingtools/ir-data-api-client/commit/5e809e229b5c463) Robert Bausdorf *2022-03-14 14:57:28*

**License info and readme added**


[013f9](https://github.com/simracingtools/ir-data-api-client/commit/013f9588619881f) Robert Bausdorf *2022-03-14 12:20:32*

**Initial commit**


[c988e](https://github.com/simracingtools/ir-data-api-client/commit/c988ea1d331d723) Robert Bausdorf *2022-03-14 11:54:20*


