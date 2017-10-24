(ns user
  (:require [figwheel-sidecar.repl-api]))

(defn start! []
  (figwheel-sidecar.repl-api/start-figwheel!
    (figwheel-sidecar.config/fetch-config)
    "dev-build")
  (figwheel-sidecar.repl-api/cljs-repl "dev-build"))
