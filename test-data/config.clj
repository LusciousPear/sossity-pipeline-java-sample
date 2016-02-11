{:config    {:remote-composer-classpath "/usr/local/lib/angleddream-bundled-0.1-ALPHA.jar"
             :remote-libs-path          "/usr/local/lib"
             :error-buckets             true}
 :cluster   {:name        "hxhstack" :initial_node_count 3 :master_auth {:username "hx" :password "hstack"}
             :node_config {:oauth_scopes ["https://www.googleapis.com/auth/compute"
                                          "https://www.googleapis.com/auth/devstorage.read_only"
                                          "https://www.googleapis.com/auth/logging.write"
                                          "https://www.googleapis.com/auth/monitoring"
                                          "https://www.googleapis.com/auth/cloud-platform"]
                           :machine_type "n1-standard-4"}}
 :opts      {:maxNumWorkers   "1" :numWorkers "1" :zone "europe-west1-c" :workerMachineType "n1-standard-1"
             :stagingLocation "gs://hx-test/staging-eu"}
 :provider  {:credentials "${file(\"/home/ubuntu/demo-config/account.json\")}" :project "hx-test"}
 :pipelines {"pipelineB"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"}
             "pipelineC"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"}
             "pipelineD"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"}
             "pipelineE"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"}}
 :sources   {"sourceA" {:type "kub"}}
 :sinks     {"sinkB" {:type "gcs" :bucket "sinkB-test"}
             "sinkD" {:type "gcs" :bucket "sinkD-test"}
             "sinkE" {:type "gcs" :bucket "sinkE-test"}
             }
 :edges     [{:origin "sourceA" :targets ["pipelineB" "pipelineC"]}
             {:origin "pipelineB" :targets ["sinkB"]}
             {:origin "pipelineC" :targets ["pipelineD" "pipelineE"]}
             {:origin "pipelineD" :targets ["sinkD"]}
             {:origin "pipelineE" :targets ["sinkE"]}]}

