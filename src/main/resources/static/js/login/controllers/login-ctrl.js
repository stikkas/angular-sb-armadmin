Lg.controller('loginCtrl', ['$scope', '$http', '$httpParamSerializerJQLike',
	'$window', function ($scope, $http, $httpParamSerializerJQLike, $window) {
		/*
		 $http.defaults.headers.common.Authorization = "Basic "
		 + btoa('sic_s' + ":" + 'sic_s');
		 */
		$scope.cred = {};
		$scope.login = function () {
			$http({url: "/login",
				method: 'POST',
				data: $httpParamSerializerJQLike($scope.cred),
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				}
			})
					.success(function () {
						$window.location.href = '/index.html';
					});
		};
		/*
		 $http.get('/enter.html')
		 
		 .success(function (data, status, headers, config) {
		 $scope._csrf = config.headers[$http.defaults.xsrfHeaderName];
		 })
		 .error(function (data, status, headers, config) {
		 $scope._csrf = config.headers[$http.defaults.xsrfHeaderName];
		 });
		 */
	}]);