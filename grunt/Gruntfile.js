var path = require('path');
module.exports = function (grunt) {
	var join = path.join,
        projectDir = path.dirname(__dirname),
        libsRoot = join(__dirname, 'node_modules'),
        rootPath = join(projectDir, 'src', 'main', 'resources', 'static'),
        lessRoot = join(projectDir, 'bootstrap');

	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-cssmin');
	grunt.loadNpmTasks('grunt-contrib-watch');

	grunt.initConfig({
		paths: {
			src: {
				js: [join(rootPath, 'js', 'app', '**', '*.js'), '!' + join(rootPath, 'js', 'app', '**', '*.min.js')],
				css: [join(rootPath, 'css', 'app', '**', '*.css'), '!' + join(rootPath, 'css', 'app', '**', '*.min.css')]
			},
			dest: {
				jsMin: join(rootPath, 'js', 'app', 'app.min.js'),
				cssMin: join(rootPath, 'css', 'app', 'style.min.css')
			}
		},
		uglify: {
			target: {
				src: '<%= paths.src.js %>',
				dest: '<%= paths.dest.jsMin %>'
			}
		},
		cssmin: {
			target: {
				src: '<%= paths.src.css %>',
				dest: '<%= paths.dest.cssMin %>'
			}
		},
		concat: {
			target1: {
				files: {
					join(rootPath, 'js', 'libs', 'angular.min.js'): [
						join(libsRoot, 'angular', 'angular.min.js'),
						join(libsRoot, 'angular-route', 'angular-route.min.js'),
						join(libsRoot, 'angular-resource', 'angular-resource.min.js')
					],
					join(rootPath, 'css', 'libs', 'bootstrap.min.css'): [
						join(libsRoot, 'bootstrap', 'dist', 'css', 'bootstrap.min.css'),
						join(libsRoot, 'bootstrap', 'dist', 'css', 'bootstrap-theme.min.css')
					]
				}
			}
		},
		watch: {
			styles: {
				files: '<%= paths.src.css %>',
				tasks: ['cssmin']
			},
			scripts: {
				files: '<%= paths.src.js %>',
				tasks: ['uglify']
			},
			grunt: {
				files: ['Gruntfile.js'],
				tasks: []
			}
		}
	});

	grunt.registerTask('vendor', 'concat');
	grunt.registerTask('default', ['uglify', 'cssmin', 'watch']);
};

