(ns user
  (:require [tictactoe.server]
            [ring.middleware.reload :refer [wrap-reload]]
            [figwheel-sidecar.repl-api :as figwheel]))

;; Let Clojure warn you when it needs to reflect on types, or when it does math
;; on unboxed numbers. In both cases you should add type annotations to prevent
;; degraded performance.
(set! *warn-on-reflection* true)
(set! *unchecked-math* :warn-on-boxed)
(def http-handler
  (wrap-reload #'tictactoe.server/http-handler))

(defn run []
  (figwheel/start-figwheel!))

;;(enable-console-print!)

(def browser-repl figwheel/cljs-repl)
