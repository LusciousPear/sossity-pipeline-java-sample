# sossity-pipeline-java-sample
Sample java pipeline for Sossity


==Simulator Instructions==

1. Clone this repo
1. `wget https://s3.amazonaws.com/com.22acacia/releases/sossity/sossity/sossity-0.1.0-ALPHA-standalone.jar`
2. ./simulate.sh test-data/config.clj

==How it Works==

The Sossity simulator works by parsing the same config file you'd use to define a cluster, and instead creating a virtual, in-process cluster of core.async channels and routines.

