; ModuleID = 'dp_1.4.bc'
target datalayout = "e-p:32:32:32-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:32:64-f32:32:32-f64:32:64-v64:64:64-v128:128:128-a0:0:64-f80:32:32"
target triple = "i386-pc-linux-gnu"

%struct.__pthread_mutex_s = type { i32, i32, i32, i32, i32, %struct.anon }
%struct.__pthread_slist_t = type { %struct.__pthread_slist_t* }
%struct.anon = type { i32 }
%struct.pthread_attr_t = type { i32, [32 x i8] }
%struct.pthread_mutex_t = type { %struct.__pthread_mutex_s }

@forkA = internal global %struct.pthread_mutex_t zeroinitializer ; <%struct.pthread_mutex_t*> [#uses=3]
@forkB = internal global %struct.pthread_mutex_t zeroinitializer ; <%struct.pthread_mutex_t*> [#uses=3]
@.str = private constant [19 x i8] c"((void *)0) == arg\00", align 1 ; <[19 x i8]*> [#uses=1]
@.str1 = private constant [9 x i8] c"dp_1.4.c\00", align 1 ; <[9 x i8]*> [#uses=1]
@__PRETTY_FUNCTION__.3260 = internal constant [12 x i8] c"philosopher\00" ; <[12 x i8]*> [#uses=1]
@p1 = internal global i32 0                       ; <i32*> [#uses=3]
@.str2 = private constant [12 x i8] c"0 == status\00", align 1 ; <[12 x i8]*> [#uses=1]
@.str3 = private constant [11 x i8] c"%d: got A\0A\00", align 1 ; <[11 x i8]*> [#uses=1]
@.str4 = private constant [11 x i8] c"%d: got B\0A\00", align 1 ; <[11 x i8]*> [#uses=1]
@.str5 = private constant [12 x i8] c"%d: eating\0A\00", align 1 ; <[12 x i8]*> [#uses=1]
@.str6 = private constant [16 x i8] c"%d: forks down\0A\00", align 1 ; <[16 x i8]*> [#uses=1]
@__PRETTY_FUNCTION__.3298 = internal constant [5 x i8] c"main\00" ; <[5 x i8]*> [#uses=1]
@p2 = internal global i32 0                       ; <i32*> [#uses=2]

define internal void @doze() nounwind {
entry:
  %0 = call i32 @random() nounwind                ; <i32> [#uses=1]
  %1 = srem i32 %0, 2000000                       ; <i32> [#uses=1]
  %2 = call i32 @usleep(i32 %1) nounwind          ; <i32> [#uses=0]
  br label %return

return:                                           ; preds = %entry
  ret void
}

declare i32 @random() nounwind

declare i32 @usleep(i32)

define internal i8* @philosopher(i8* %arg) nounwind {
entry:
  %arg_addr = alloca i8*                          ; <i8**> [#uses=2]
  %retval = alloca i8*                            ; <i8**> [#uses=1]
  %status = alloca i32                            ; <i32*> [#uses=12]
  %id = alloca i32                                ; <i32*> [#uses=8]
  %tid = alloca i32                               ; <i32*> [#uses=2]
  %0 = alloca i8*                                 ; <i8**> [#uses=0]
  %"alloca point" = bitcast i32 0 to i32          ; <i32> [#uses=0]
  store i8* %arg, i8** %arg_addr
  %1 = load i8** %arg_addr, align 4               ; <i8*> [#uses=1]
  %2 = icmp ne i8* %1, null                       ; <i1> [#uses=1]
  br i1 %2, label %bb, label %bb1

bb:                                               ; preds = %entry
  call void @__assert_fail(i8* getelementptr inbounds ([19 x i8]* @.str, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 27, i8* getelementptr inbounds ([12 x i8]* @__PRETTY_FUNCTION__.3260, i32 0, i32 0)) noreturn nounwind
  unreachable

bb1:                                              ; preds = %entry
  %3 = call i32 @pthread_self() nounwind readnone ; <i32> [#uses=1]
  store i32 %3, i32* %tid, align 4
  %4 = load i32* @p1, align 4                     ; <i32> [#uses=1]
  %5 = load i32* %tid, align 4                    ; <i32> [#uses=1]
  %6 = call i32 @pthread_equal(i32 %5, i32 %4) nounwind ; <i32> [#uses=1]
  %7 = icmp ne i32 %6, 0                          ; <i1> [#uses=1]
  br i1 %7, label %bb2, label %bb3

bb2:                                              ; preds = %bb1
  store i32 1, i32* %id, align 4
  br label %bb4

bb3:                                              ; preds = %bb1
  store i32 2, i32* %id, align 4
  br label %bb4

bb4:                                              ; preds = %bb19, %bb3, %bb2
  %8 = call i32 @random() nounwind                ; <i32> [#uses=1]
  %9 = icmp sle i32 %8, 1073741822                ; <i1> [#uses=1]
  br i1 %9, label %bb5, label %bb10

bb5:                                              ; preds = %bb4
  %10 = call i32 @pthread_mutex_lock(%struct.pthread_mutex_t* @forkA) nounwind ; <i32> [#uses=1]
  store i32 %10, i32* %status, align 4
  %11 = load i32* %status, align 4                ; <i32> [#uses=1]
  %12 = icmp ne i32 %11, 0                        ; <i1> [#uses=1]
  br i1 %12, label %bb6, label %bb7

bb6:                                              ; preds = %bb5
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 38, i8* getelementptr inbounds ([12 x i8]* @__PRETTY_FUNCTION__.3260, i32 0, i32 0)) noreturn nounwind
  unreachable

bb7:                                              ; preds = %bb5
  %13 = load i32* %id, align 4                    ; <i32> [#uses=1]
  %14 = call i32 (i8*, ...)* @printf(i8* noalias getelementptr inbounds ([11 x i8]* @.str3, i32 0, i32 0), i32 %13) nounwind ; <i32> [#uses=0]
  call void @doze() nounwind
  %15 = call i32 @pthread_mutex_lock(%struct.pthread_mutex_t* @forkB) nounwind ; <i32> [#uses=1]
  store i32 %15, i32* %status, align 4
  %16 = load i32* %status, align 4                ; <i32> [#uses=1]
  %17 = icmp ne i32 %16, 0                        ; <i1> [#uses=1]
  br i1 %17, label %bb8, label %bb9

bb8:                                              ; preds = %bb7
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 42, i8* getelementptr inbounds ([12 x i8]* @__PRETTY_FUNCTION__.3260, i32 0, i32 0)) noreturn nounwind
  unreachable

bb9:                                              ; preds = %bb7
  %18 = load i32* %id, align 4                    ; <i32> [#uses=1]
  %19 = call i32 (i8*, ...)* @printf(i8* noalias getelementptr inbounds ([11 x i8]* @.str4, i32 0, i32 0), i32 %18) nounwind ; <i32> [#uses=0]
  br label %bb15

bb10:                                             ; preds = %bb4
  %20 = call i32 @pthread_mutex_lock(%struct.pthread_mutex_t* @forkB) nounwind ; <i32> [#uses=1]
  store i32 %20, i32* %status, align 4
  %21 = load i32* %status, align 4                ; <i32> [#uses=1]
  %22 = icmp ne i32 %21, 0                        ; <i1> [#uses=1]
  br i1 %22, label %bb11, label %bb12

bb11:                                             ; preds = %bb10
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 47, i8* getelementptr inbounds ([12 x i8]* @__PRETTY_FUNCTION__.3260, i32 0, i32 0)) noreturn nounwind
  unreachable

bb12:                                             ; preds = %bb10
  %23 = load i32* %id, align 4                    ; <i32> [#uses=1]
  %24 = call i32 (i8*, ...)* @printf(i8* noalias getelementptr inbounds ([11 x i8]* @.str4, i32 0, i32 0), i32 %23) nounwind ; <i32> [#uses=0]
  call void @doze() nounwind
  %25 = call i32 @pthread_mutex_lock(%struct.pthread_mutex_t* @forkA) nounwind ; <i32> [#uses=1]
  store i32 %25, i32* %status, align 4
  %26 = load i32* %status, align 4                ; <i32> [#uses=1]
  %27 = icmp ne i32 %26, 0                        ; <i1> [#uses=1]
  br i1 %27, label %bb13, label %bb14

bb13:                                             ; preds = %bb12
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 51, i8* getelementptr inbounds ([12 x i8]* @__PRETTY_FUNCTION__.3260, i32 0, i32 0)) noreturn nounwind
  unreachable

bb14:                                             ; preds = %bb12
  %28 = load i32* %id, align 4                    ; <i32> [#uses=1]
  %29 = call i32 (i8*, ...)* @printf(i8* noalias getelementptr inbounds ([11 x i8]* @.str3, i32 0, i32 0), i32 %28) nounwind ; <i32> [#uses=0]
  br label %bb15

bb15:                                             ; preds = %bb14, %bb9
  %30 = load i32* %id, align 4                    ; <i32> [#uses=1]
  %31 = call i32 (i8*, ...)* @printf(i8* noalias getelementptr inbounds ([12 x i8]* @.str5, i32 0, i32 0), i32 %30) nounwind ; <i32> [#uses=0]
  call void @doze() nounwind
  %32 = call i32 @pthread_mutex_unlock(%struct.pthread_mutex_t* @forkA) nounwind ; <i32> [#uses=1]
  store i32 %32, i32* %status, align 4
  %33 = load i32* %status, align 4                ; <i32> [#uses=1]
  %34 = icmp ne i32 %33, 0                        ; <i1> [#uses=1]
  br i1 %34, label %bb16, label %bb17

bb16:                                             ; preds = %bb15
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 57, i8* getelementptr inbounds ([12 x i8]* @__PRETTY_FUNCTION__.3260, i32 0, i32 0)) noreturn nounwind
  unreachable

bb17:                                             ; preds = %bb15
  %35 = call i32 @pthread_mutex_unlock(%struct.pthread_mutex_t* @forkB) nounwind ; <i32> [#uses=1]
  store i32 %35, i32* %status, align 4
  %36 = load i32* %status, align 4                ; <i32> [#uses=1]
  %37 = icmp ne i32 %36, 0                        ; <i1> [#uses=1]
  br i1 %37, label %bb18, label %bb19

bb18:                                             ; preds = %bb17
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 59, i8* getelementptr inbounds ([12 x i8]* @__PRETTY_FUNCTION__.3260, i32 0, i32 0)) noreturn nounwind
  unreachable

bb19:                                             ; preds = %bb17
  %38 = load i32* %id, align 4                    ; <i32> [#uses=1]
  %39 = call i32 (i8*, ...)* @printf(i8* noalias getelementptr inbounds ([16 x i8]* @.str6, i32 0, i32 0), i32 %38) nounwind ; <i32> [#uses=0]
  call void @doze() nounwind
  br label %bb4

return:                                           ; No predecessors!
  %retval20 = load i8** %retval                   ; <i8*> [#uses=1]
  ret i8* %retval20
}

declare void @__assert_fail(i8*, i8*, i32, i8*) noreturn nounwind

declare i32 @pthread_self() nounwind readnone

declare i32 @pthread_equal(i32, i32) nounwind

declare i32 @pthread_mutex_lock(%struct.pthread_mutex_t*) nounwind

declare i32 @printf(i8* noalias, ...) nounwind

declare i32 @pthread_mutex_unlock(%struct.pthread_mutex_t*) nounwind

define i32 @main(i32 %argc, i8** %argv) nounwind {
entry:
  %argc_addr = alloca i32                         ; <i32*> [#uses=2]
  %argv_addr = alloca i8**                        ; <i8***> [#uses=2]
  %retval = alloca i32                            ; <i32*> [#uses=2]
  %status = alloca i32                            ; <i32*> [#uses=8]
  %0 = alloca i32                                 ; <i32*> [#uses=2]
  %"alloca point" = bitcast i32 0 to i32          ; <i32> [#uses=0]
  store i32 %argc, i32* %argc_addr
  store i8** %argv, i8*** %argv_addr
  %1 = load i32* %argc_addr, align 4              ; <i32> [#uses=1]
  %2 = icmp eq i32 %1, 2                          ; <i1> [#uses=1]
  br i1 %2, label %bb, label %bb1

bb:                                               ; preds = %entry
  %3 = load i8*** %argv_addr, align 4             ; <i8**> [#uses=1]
  %4 = getelementptr inbounds i8** %3, i32 1      ; <i8**> [#uses=1]
  %5 = load i8** %4, align 1                      ; <i8*> [#uses=1]
  %6 = call i32 @atoi(i8* %5) nounwind readonly   ; <i32> [#uses=1]
  call void @srandom(i32 %6) nounwind
  br label %bb1

bb1:                                              ; preds = %bb, %entry
  %7 = call i32 @pthread_create(i32* noalias @p1, %struct.pthread_attr_t* noalias null, i8* (i8*)* @philosopher, i8* noalias null) nounwind ; <i32> [#uses=1]
  store i32 %7, i32* %status, align 4
  %8 = load i32* %status, align 4                 ; <i32> [#uses=1]
  %9 = icmp ne i32 %8, 0                          ; <i1> [#uses=1]
  br i1 %9, label %bb2, label %bb3

bb2:                                              ; preds = %bb1
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 74, i8* getelementptr inbounds ([5 x i8]* @__PRETTY_FUNCTION__.3298, i32 0, i32 0)) noreturn nounwind
  unreachable

bb3:                                              ; preds = %bb1
  %10 = call i32 @pthread_create(i32* noalias @p2, %struct.pthread_attr_t* noalias null, i8* (i8*)* @philosopher, i8* noalias null) nounwind ; <i32> [#uses=1]
  store i32 %10, i32* %status, align 4
  %11 = load i32* %status, align 4                ; <i32> [#uses=1]
  %12 = icmp ne i32 %11, 0                        ; <i1> [#uses=1]
  br i1 %12, label %bb4, label %bb5

bb4:                                              ; preds = %bb3
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 76, i8* getelementptr inbounds ([5 x i8]* @__PRETTY_FUNCTION__.3298, i32 0, i32 0)) noreturn nounwind
  unreachable

bb5:                                              ; preds = %bb3
  %13 = load i32* @p1, align 4                    ; <i32> [#uses=1]
  %14 = call i32 @pthread_join(i32 %13, i8** null) nounwind ; <i32> [#uses=1]
  store i32 %14, i32* %status, align 4
  %15 = load i32* %status, align 4                ; <i32> [#uses=1]
  %16 = icmp ne i32 %15, 0                        ; <i1> [#uses=1]
  br i1 %16, label %bb6, label %bb7

bb6:                                              ; preds = %bb5
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 80, i8* getelementptr inbounds ([5 x i8]* @__PRETTY_FUNCTION__.3298, i32 0, i32 0)) noreturn nounwind
  unreachable

bb7:                                              ; preds = %bb5
  %17 = load i32* @p2, align 4                    ; <i32> [#uses=1]
  %18 = call i32 @pthread_join(i32 %17, i8** null) nounwind ; <i32> [#uses=1]
  store i32 %18, i32* %status, align 4
  %19 = load i32* %status, align 4                ; <i32> [#uses=1]
  %20 = icmp ne i32 %19, 0                        ; <i1> [#uses=1]
  br i1 %20, label %bb8, label %bb9

bb8:                                              ; preds = %bb7
  call void @__assert_fail(i8* getelementptr inbounds ([12 x i8]* @.str2, i32 0, i32 0), i8* getelementptr inbounds ([9 x i8]* @.str1, i32 0, i32 0), i32 82, i8* getelementptr inbounds ([5 x i8]* @__PRETTY_FUNCTION__.3298, i32 0, i32 0)) noreturn nounwind
  unreachable

bb9:                                              ; preds = %bb7
  store i32 0, i32* %0, align 4
  %21 = load i32* %0, align 4                     ; <i32> [#uses=1]
  store i32 %21, i32* %retval, align 4
  br label %return

return:                                           ; preds = %bb9
  %retval10 = load i32* %retval                   ; <i32> [#uses=1]
  ret i32 %retval10
}

declare i32 @atoi(i8*) nounwind readonly

declare void @srandom(i32) nounwind

declare i32 @pthread_create(i32* noalias, %struct.pthread_attr_t* noalias, i8* (i8*)*, i8* noalias) nounwind

declare i32 @pthread_join(i32, i8**)
