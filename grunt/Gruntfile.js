var path = require('path');
module.exports = function (grunt) {
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-cssmin');
	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-contrib-less');

	var join = path.join,
			projectDir = path.dirname(__dirname),
			libsRoot = join(__dirname, 'node_modules'),
			rootPath = join(projectDir, 'src', 'main', 'resources', 'static'),
			lessRoot = join(projectDir, 'bootstrap');

	grunt.initConfig({
		// Пути к исходным и результирующим файлам
		paths: {
			src: {
				js: [join(rootPath, 'js', 'app', '**', '*.js'), '!' + join(rootPath, 'js', 'app', '**', '*.min.js')],
				css: [join(rootPath, 'css', 'app', '**', '*.css'), '!' + join(rootPath, 'css', 'app', '**', '*.min.css')],
				theme: join(lessRoot, 'app-theme.less')
			},
			dest: {
				angular: join(rootPath, 'js', 'libs', 'app.min.js'),
				jsMin: join(rootPath, 'js', 'app', 'app.min.js'),
				cssMin: join(rootPath, 'css', 'app', 'app.min.css'),
				theme: join(rootPath, 'css', 'libs', 'app.min.css')
			},
			loginSrc: {
				js: [join(rootPath, 'js', 'login', '**', '*.js'), '!' + join(rootPath, 'js', 'login', '**', '*.min.js')],
				css: [join(rootPath, 'css', 'login', '**', '*.css'), '!' + join(rootPath, 'css', 'login', '**', '*.min.css')],
				theme: join(lessRoot, 'login-theme.less')
			},
			loginDest: {
				angular: join(rootPath, 'js', 'libs', 'login.min.js'),
				jsMin: join(rootPath, 'js', 'login', 'login.min.js'),
				cssMin: join(rootPath, 'css', 'login', 'login.min.css'),
				theme: join(rootPath, 'css', 'libs', 'login.min.css')
			}
		},
		// Создание сжатых js скриптов. Из нескольких делается один на каждое приложение.
		// Всего два приложения: основное и аутентификация
		uglify: {
			app: {
				src: '<%= paths.src.js %>',
				dest: '<%= paths.dest.jsMin %>'
			},
			login: {
				src: '<%= paths.loginSrc.js %>',
				dest: '<%= paths.loginDest.jsMin %>'
			}
		},
		// Создание сжатых файлов стилей
		cssmin: {
			app: {
				src: '<%= paths.src.css %>',
				dest: '<%= paths.dest.cssMin %>'
			},
			login: {
				src: '<%= paths.loginSrc.css %>',
				dest: '<%= paths.loginDest.cssMin %>'
			}
		},
		// Создание файлов библиотек. Из нескольких библиотек собирается один файл.
		// Т.е. на каждое приложение один файл библиотеки скриптов
		concat: {
			app: {
				files: {
					'<%= paths.dest.angular =>': [
						join(libsRoot, 'angular', 'angular.min.js'),
						join(libsRoot, 'angular-route', 'angular-route.min.js'),
						join(libsRoot, 'angular-resource', 'angular-resource.min.js')
					]
				}
			},
			login: {
				files: {
					'<%= paths.loginDest.angular =>': [
						join(libsRoot, 'angular', 'angular.min.js')
					]
				}
			}
		},
		// Компилирование темы bootstrap
		less: {
			app: {
				options: {compress: true},
				files: {
					'<%= paths.dest.theme %>': '<%= paths.src.theme %>'
				}
			},
			login: {
				options: {compress: true},
				files: {
					'<%= paths.loginDest.theme %>': '<%= paths.loginSrc.theme %>'
				}
			}
		},
		// Автоматическое формирование файлов во время разработки
		watch: {
			appStyle: {
				files: '<%= paths.src.css %>',
				tasks: ['cssmin:app']
			},
			appScript: {
				files: '<%= paths.src.js %>',
				tasks: ['uglify:app']
			},
			loginStyle: {
				files: '<%= paths.loginSrc.css %>',
				tasks: ['cssmin:login']
			},
			loginScript: {
				files: '<%= paths.loginSrc.js %>',
				tasks: ['uglify:login']
			},
			appTheme: {
				files: '<%= paths.src.theme %>',
				tasks: ['less:app']
			},
			loginTheme: {
				files: '<%= paths.loginSrc.theme %>',
				tasks: ['less:login']
			},
			grunt: {
				files: ['Gruntfile.js'],
				tasks: []
			}
		}
	});

	// Задачи
	grunt.registerTask('vendor', 'concat');
	grunt.registerTask('default', ['uglify', 'cssmin', 'less', 'watch']);
};

