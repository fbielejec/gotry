(ns gotry.core
  (:require [cljs.core.async :as async :refer [<! >!]]           
            [cljs.nodejs :as nodejs])
  (:require-macros ;;[cljs.core.async.macros :refer [go]]
                   [gotry.macros :refer [gotry]]))

(nodejs/enable-util-print!)

(defn on-js-load []
  (prn "@on-js-load")
  (gotry
   (let [c (async/chan 1)]
     (>! c "FUBAR")
     (prn (<! c)))))

(set! *main-cli-fn* on-js-load)
