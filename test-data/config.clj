{:config    {:remote-composer-classpath "/usr/local/lib/angleddream-bundled-0.1-ALPHA.jar"
             :remote-libs-path          "/usr/local/lib"
             :error-buckets             true
             :sink-resource-version     "1"
             :source-resource-version   "1"
             :appengine-gstoragekey     "hxtest-1.0-SNAPSHOT"
             :default-sink-docker-image "gcr.io/hx-test/store-sink"
             :system-jar-info           {:angleddream {:name "angleddream-bundled-0.1-ALPHA.jar"
                                                       :pail "build-artifacts-public-eu"
                                                       :key  "angleddream"}
                                         :sossity     {:name "sossity-0.1.0-SNAPSHOT-standalone.jar"
                                                       :pail "build-artifacts-public-eu"
                                                       :key  "sossity"}}}
 :cluster   {:name        "hxhstack" :initial_node_count 3 :master_auth {:username "hx" :password "hstack"}
             :node_config {:oauth_scopes ["https://www.googleapis.com/auth/compute"
                                          "https://www.googleapis.com/auth/devstorage.read_only"
                                          "https://www.googleapis.com/auth/logging.write"
                                          "https://www.googleapis.com/auth/monitoring"
                                          "https://www.googleapis.com/auth/cloud-platform"]
                           :machine_type "n1-standard-4"}}
 :opts      {:maxNumWorkers   1 :numWorkers 1 :zone "europe-west1-c" :workerMachineType "n1-standard-1"
             :stagingLocation "gs://hx-test/staging-eu"}
 :provider  {:credentials "${file(\"/home/ubuntu/demo-config/account.json\")}" :project "hx-trial"}
 :containers {}
 :pipelines {"pipelineB"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"
              :pail          "build-artifacts-public-eu"
              :key           "sossity-identity-pipeline-java"}
             "pipelineC"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"
              :pail          "build-artifacts-public-eu"
              :key           "sossity-identity-pipeline-java"}
             "pipelineD"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"
              :pail          "build-artifacts-public-eu"
              :key           "sossity-identity-pipeline-java"}
             "pipelineE"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"
              :pail          "build-artifacts-public-eu"
              :key           "sossity-identity-pipeline-java"}}
 "pipelineF"
            {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"
             :pail          "build-artifacts-public-eu"
             :key           "sossity-identity-pipeline-java"}

 :sources {"sourceA" {:type "gae"}}
 :sinks     {"sinkB" {:type "gcs" :bucket "sinkB-test"}
             "sinkD" {:type "gcs" :bucket "sinkD-test"}
             "sinkE" {:type "gcs" :bucket "sinkE-test"}}
 :edges     [{:origin "sourceA" :targets ["pipelineB" "pipelineC"]}
             {:origin "pipelineB" :targets ["pipelineF" "sinkB"]}
             {:origin "pipelineC" :targets ["pipelineD" "pipelineE"]}
             {:origin "pipelineF" :targets ["sinkD"]}
             {:origin "pipelineD" :targets ["sinkD"]}
             {:origin "pipelineE" :targets ["sinkE"]}]}

