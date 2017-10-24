(defproject gotry "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojurescript "1.9.946"]]

  :exclusions [[org.clojure/clojure]
               [org.clojure/clojurescript]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.11"]
            [lein-doo "0.1.7"]
            [lein-npm "0.6.2"]]

  :npm {:dependencies [[ws "3.2.0"]
                       [karma "1.5.0"]
                       [karma-cli "1.0.1"]
                       [karma-cljs-test "0.1.0"]]}

  :doo {:paths {:karma "./node_modules/karma/bin/karma"}}

  :min-lein-version "2.5.3"

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["dev" "target"]

  :figwheel {:server-port 8080}

  :profiles {:dev {:dependencies [[org.clojure/clojure "1.8.0"]
                                  [binaryage/devtools "0.9.7"]
                                  [com.cemerick/piggieback "0.2.2"]
                                  [figwheel-sidecar "0.5.14"]
                                  [org.clojure/tools.nrepl "0.2.13"]]        
                   :source-paths ["dev"]
                   :resource-paths ["resources"]}}

  :cljsbuild {:builds [{:id "dev-build"
                        :source-paths ["src"]
                        :figwheel {:on-jsload "gotry.core/on-jsload"}
                        :compiler {:main "gotry.core"
                                   :output-to "dev-build/gotry.js"
                                   :output-dir "dev-build"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}]})
