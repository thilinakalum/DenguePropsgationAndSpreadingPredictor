(function () {
    angular.module("appModule")
            .factory("riskAnlysisService", function ($http, systemConfig) {
                var factory = {};

                factory.findAllDistricts = function (callback, errorCallback) {
                    var url = systemConfig.apiUrl + "/api/final-project/dpasp/districts/find-all-districts";
                    $http.get(url)
                            .success(function (data, status, headers) {
                                callback(data);
                            })
                            .error(function (data, status, headers) {
                                if (errorCallback) {
                                    errorCallback(data);
                                }
                            });
                };

                factory.findChartData = function (districts, month, week, callback, errorCallback) {
                    var url = systemConfig.apiUrl + "/api/final-project/dpasp/moh-patients-details/find-by-district-and-dates/" + districts + "/" + month + "/" + week;
                    $http.get(url)
                            .success(function (data, status, headers) {
                                callback(data);
                            })
                            .error(function (data, status, headers) {
                                if (errorCallback) {
                                    errorCallback(data);
                                }
                            });
                };

                factory.findMohOfficeByDistrict = function (districts, callback, errorCallback) {
                    var url = systemConfig.apiUrl + "/api/final-project/dpasp/moh/find-moh-by-districts/" + districts;
                    $http.get(url)
                            .success(function (data, status, headers) {
                                callback(data);
                            })
                            .error(function (data, status, headers) {
                                if (errorCallback) {
                                    errorCallback(data);
                                }
                            });
                };

                factory.predictRisk = function (districts, moh, date, callback, errorCallback) {
                    var url = systemConfig.apiUrl + "/api/final-project/dpasp/moh-patients-details/predict-risk/" + districts + "/" + moh + "/" + date;
                    $http.get(url)
                            .success(function (data, status, headers) {
                                callback(data);
                            })
                            .error(function (data, status, headers) {
                                if (errorCallback) {
                                    errorCallback(data);
                                }
                            });
                };

                return factory;
            });
}());


