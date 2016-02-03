# sossity-pipeline-java-sample
Sample java pipeline for Sossity


## Simulator Instructions 

1. Clone this repo
1. `wget https://s3.amazonaws.com/com.22acacia/releases/sossity/sossity/sossity-0.1.0-SNAPSHOT-standalone.jar`
1. `/simulate.sh test-data/config.clj`

## How it Works (Basic) 

The Sossity simulator works by parsing the same config file you'd use to define a cluster, and instead creating a virtual, in-process cluster of core.async channels and routines.

The JSON envelope for all messages is like:
`{"resource_hash":"2054aa421fb7692d9bcdbcd4dee9bddd","resource":<original data>,"transforms":["2016-02-03T08:13.16.280+0000"],"id":"fa0e93a0-ca4d-11e5-9ebb-c92268108495","timestamp":"2016-02-03T08:13:16.115Z"}`

Wherein the original data in "resource" is wrapped with metadata.


## Brief Instructions (assuming Java familiarity) 


1. Make sure Java 1.8 is installed, Oracle JDK preferred, as well as Maven3.
1. To experiment with changing the data, the only file you need to change is `/home/bradford/proj/sossity-pipeline-java-sample/src/main/java/com/acacia/timestamppipeline/TimestampPipeline.java` -- remember to adhere to the envelope format.
1. Re-compile pipeline sample with `mvn package`
1. To build multiple pipelines, clone this repo multiple times and change the `<artifactId>timestamppipeline</artifactId>` in `pom.xml` to change the JAR name.
1. Refer to `test-data/config.clj` to change the pipeline topology as well as sample input data. The only fields you need to edit are `:pipelines, :sources, :sinks, :edges`
1. After compiling pipelines and editing config file, run `./simulate.sh <path-to-config>` again. 

