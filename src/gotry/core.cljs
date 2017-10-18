(ns gotry.core
  (:require [cljs.core.async :as async :refer [<! >!]]
            [cljs.core.async :refer [<! >! chan]]
            [cljs.nodejs :as nodejs]
            [gotry.macros :refer [gotry]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(nodejs/enable-util-print!)

(defn on-js-load []
  (prn "@on-js-load")
  (gotry
   (let [c (async/chan 1)]
     (>! c "FUBAR")
     (prn (<! c)))))

(set! *main-cli-fn* on-js-load)
