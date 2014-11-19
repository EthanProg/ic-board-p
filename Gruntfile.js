/*global module:false*/
module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    // 项目配置
    pkg: grunt.file.readJSON('package.json'),
    banner: '/*! <%= pkg.title || pkg.name %> - v<%= pkg.version %> - ' +
      '<%= grunt.template.today("yyyy-mm-dd") %>\n' +
      '<%= pkg.homepage ? "* " + pkg.homepage + "\\n" : "" %>' +
      '* Copyright (c) <%= grunt.template.today("yyyy") %> <%= pkg.author.name %>;' +
      ' Licensed <%= _.pluck(pkg.licenses, "type").join(", ") %> */\n',
    //alert(banner);
    // Task configuration.
    concat: {
      options: {
        banner: '<%= banner %>',
        stripBanners: true
      },
      dist: {
        src: ['lib/<%= pkg.name %>.js'],
        dest: 'dist/<%= pkg.name %>.js'
      }
    },
    uglify: {
      options: {
        banner: '<%= banner %>'
      },
      dist: {
        src: '<%= concat.dist.dest %>',
        dest: 'dist/<%= pkg.name %>.min.js'
      }
    },
    jshint: {
      options: {
        curly: true,
        eqeqeq: true,
        immed: true,
        latedef: true,
        newcap: true,
        noarg: true,
        sub: true,
        undef: true,
        unused: true,
        boss: true,
        eqnull: true,
        browser: true,
        globals: {
          jQuery: true
        }
      },
      gruntfile: {
        src: 'Gruntfile.js'
      },
      lib_test: {
        src: ['lib/**/*.js', 'test/**/*.js']
      }
    },
    qunit: {
      files: ['test/**/*.html']
    },
    watch: {
      gruntfile: {
        files: '<%= jshint.gruntfile.src %>',
        tasks: ['jshint:gruntfile']
      },
      lib_test: {
        files: '<%= jshint.lib_test.src %>',
        tasks: ['jshint:lib_test', 'qunit']
      }
    },
    bower: {
      install: {
        options: {
          targetDir: './src/main/webapp/scripts',
          layout: 'byComponent',
          install: true,
          verbose: false,
          cleanTargetDir: false,
          cleanBowerDir: false,
          bowerOptions: {}
        }
      }
    }
  });

  // 加载所需要的插件

  //concat 文件合并插件
  grunt.loadNpmTasks('grunt-contrib-concat');

  //文件压缩
  grunt.loadNpmTasks('grunt-contrib-uglify');

  //
  grunt.loadNpmTasks('grunt-contrib-qunit');

  //文件校验
  grunt.loadNpmTasks('grunt-contrib-jshint');

  //文件监控
  grunt.loadNpmTasks('grunt-contrib-watch');

  //文件复制，需要挨个的指定文件
  grunt.loadNpmTasks('grunt-bowercopy');

  //文件复制，可以按照组件或者类型，全部复制，当前使用此插件
  grunt.loadNpmTasks('grunt-bower-task');


  // Default task.默认任务，执行grunt并不指定具体任务时会执行默认
  grunt.registerTask('default', ['bower','jshint', 'qunit', 'concat', 'uglify']);

};
