(function () {
//module
    angular.module("appModule")
            .controller("riskAnlysisController", function ($scope, riskAnlysisService, $filter) {

                $scope.ui = {};
                $scope.model = {};
                var year = new Date().getFullYear();
                var month = new Date().getMonth();
                $scope.model.data = {
                    districts: 1,
                    month: new Date(year, month, 1),
                    week: 5
                };
                $scope.model.districtList = [];

                $scope.ui.findAllDistricts = function () {
                    riskAnlysisService.findAllDistricts(
                            function (data) {
                                console.log(data);
                                $scope.model.districtList = data;
                            });
                };

                $scope.ui.searchParamiter = function (data) {
                    console.log(data);
                    var month = $filter('date')(new Date(data.month), 'yyyy-MM-dd');
                    riskAnlysisService.findChartData(data.districts, month, data.week,
                            function (data) {

                                $scope.labels = [];
                                $scope.colors = ['#46BFBD'];
                                $scope.series = ['This Week', 'Last Week'];
                                $scope.datas = [
                                    [], []
                                ];
                                angular.forEach(data, function (value) {
                                    $scope.labels.push(value[0]);
                                    $scope.datas[0].push(value[1]);
                                    $scope.datas[1].push(value[2]);
                                });
                            });
                };

                $scope.ui.getMohList = function (districts) {
                    riskAnlysisService.findMohOfficeByDistrict(districts,
                            function (data) {
                                console.log(data);
                                $scope.model.mohList = data;
                            });
                };
                $scope.ui.predictRisk = function (districts,moh) {
                    var year = new Date().getFullYear();
                    var month = new Date().getMonth();
                    var date = new Date().getDate();
                    var day = $filter('date')(new Date(year, month, date - 21), 'yyyy-MM-dd');
                    riskAnlysisService.predictRisk(districts,moh, day,
                            function (data) {
                                console.log(data);
                                $scope.labelss = ['Previous Risk', 'Current Risk'];
                                $scope.colorss = ['#46BFBD'];
                                $scope.seriess = ['Previous Risk', 'Current Risk'];
                                $scope.datass = [
                                ];
                                angular.forEach(data, function (value) { 
                                    $scope.datass.push(value);
                                    console.log(value);
                                });
                            });
                };

                $scope.ui.init = function () {
                    $scope.ui.searchParamiter($scope.model.data);
                    $scope.ui.findAllDistricts();
                };
                $scope.ui.init();

            });
}());