.class public Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;
.super Lcom/watabou/noosa/ui/Component;
.source "RenderedTextBlock.java"


# static fields
.field public static final CENTER_ALIGN:I = 0x2

.field public static final LEFT_ALIGN:I = 0x1

.field private static final NEWLINE:Lcom/watabou/noosa/RenderedText;

.field public static final RIGHT_ALIGN:I = 0x3

.field private static final SPACE:Lcom/watabou/noosa/RenderedText;


# instance fields
.field private BColor:I

.field private BEnabled:Z

.field private GColor:I

.field private GEnabled:Z

.field private RColor:I

.field private REnabled:Z

.field private alignment:I

.field private color:I

.field private highlightingEnabled:Z

.field private hightlightColor:I

.field private maxWidth:I

.field protected multiline:Z

.field public nLines:I

.field private size:I

.field protected text:Ljava/lang/String;

.field protected tokens:[Ljava/lang/String;

.field protected words:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/watabou/noosa/RenderedText;",
            ">;"
        }
    .end annotation
.end field

.field private zoom:F


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 36
    new-instance v0, Lcom/watabou/noosa/RenderedText;

    invoke-direct {v0}, Lcom/watabou/noosa/RenderedText;-><init>()V

    sput-object v0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->SPACE:Lcom/watabou/noosa/RenderedText;

    .line 37
    new-instance v0, Lcom/watabou/noosa/RenderedText;

    invoke-direct {v0}, Lcom/watabou/noosa/RenderedText;-><init>()V

    sput-object v0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->NEWLINE:Lcom/watabou/noosa/RenderedText;

    return-void
.end method

.method public constructor <init>(I)V
    .registers 4
    .param p1, "size"    # I

    .prologue
    const/4 v1, 0x1

    .line 63
    invoke-direct {p0}, Lcom/watabou/noosa/ui/Component;-><init>()V

    .line 33
    const v0, 0x7fffffff

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->maxWidth:I

    .line 40
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->tokens:[Ljava/lang/String;

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->multiline:Z

    .line 46
    const/4 v0, -0x1

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->color:I

    .line 48
    const v0, 0xffff

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->hightlightColor:I

    .line 49
    const/high16 v0, 0xff0000

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->RColor:I

    .line 50
    const v0, 0xff00

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->GColor:I

    .line 51
    const/16 v0, 0xff

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->BColor:I

    .line 53
    iput-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->highlightingEnabled:Z

    .line 54
    iput-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->REnabled:Z

    .line 55
    iput-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->GEnabled:Z

    .line 56
    iput-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->BEnabled:Z

    .line 61
    iput v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->alignment:I

    .line 64
    iput p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->size:I

    .line 65
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .registers 5
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "size"    # I

    .prologue
    const/4 v1, 0x1

    .line 67
    invoke-direct {p0}, Lcom/watabou/noosa/ui/Component;-><init>()V

    .line 33
    const v0, 0x7fffffff

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->maxWidth:I

    .line 40
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->tokens:[Ljava/lang/String;

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->multiline:Z

    .line 46
    const/4 v0, -0x1

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->color:I

    .line 48
    const v0, 0xffff

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->hightlightColor:I

    .line 49
    const/high16 v0, 0xff0000

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->RColor:I

    .line 50
    const v0, 0xff00

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->GColor:I

    .line 51
    const/16 v0, 0xff

    iput v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->BColor:I

    .line 53
    iput-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->highlightingEnabled:Z

    .line 54
    iput-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->REnabled:Z

    .line 55
    iput-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->GEnabled:Z

    .line 56
    iput-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->BEnabled:Z

    .line 61
    iput v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->alignment:I

    .line 68
    iput p2, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->size:I

    .line 69
    invoke-virtual {p0, p1}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->text(Ljava/lang/String;)V

    .line 70
    return-void
.end method

.method private declared-synchronized build()V
    .registers 14

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 106
    monitor-enter p0

    :try_start_3
    iget-object v8, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->tokens:[Ljava/lang/String;
    :try_end_5
    .catchall {:try_start_3 .. :try_end_5} :catchall_79

    if-nez v8, :cond_9

    .line 146
    :goto_7
    monitor-exit p0

    return-void

    .line 108
    :cond_9
    :try_start_9
    invoke-virtual {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->clear()V

    .line 109
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    iput-object v8, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    .line 110
    const/4 v3, 0x0

    .line 111
    .local v3, "highlighting":Z
    const/4 v2, 0x0

    .line 112
    .local v2, "Rhighlighting":Z
    const/4 v1, 0x0

    .line 113
    .local v1, "Ghighlighting":Z
    const/4 v0, 0x0

    .line 114
    .local v0, "Bhighlighting":Z
    iget-object v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->tokens:[Ljava/lang/String;

    array-length v10, v9

    move v8, v7

    :goto_1b
    if-ge v8, v10, :cond_de

    aget-object v4, v9, v8

    .line 116
    .local v4, "str":Ljava/lang/String;
    const-string v11, "_"

    invoke-virtual {v4, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_33

    iget-boolean v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->highlightingEnabled:Z

    if-eqz v11, :cond_33

    .line 117
    if-nez v3, :cond_31

    move v3, v6

    .line 114
    :cond_2e
    :goto_2e
    add-int/lit8 v8, v8, 0x1

    goto :goto_1b

    :cond_31
    move v3, v7

    .line 117
    goto :goto_2e

    .line 118
    :cond_33
    const-string v11, "\u20ac"

    invoke-virtual {v4, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_45

    iget-boolean v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->REnabled:Z

    if-eqz v11, :cond_45

    .line 119
    if-nez v2, :cond_43

    move v2, v6

    :goto_42
    goto :goto_2e

    :cond_43
    move v2, v7

    goto :goto_42

    .line 120
    :cond_45
    const-string v11, "\uff04"

    invoke-virtual {v4, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_57

    iget-boolean v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->GEnabled:Z

    if-eqz v11, :cond_57

    .line 121
    if-nez v1, :cond_55

    move v1, v6

    :goto_54
    goto :goto_2e

    :cond_55
    move v1, v7

    goto :goto_54

    .line 122
    :cond_57
    const-string v11, "\u222e"

    invoke-virtual {v4, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_69

    iget-boolean v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->BEnabled:Z

    if-eqz v11, :cond_69

    .line 123
    if-nez v0, :cond_67

    move v0, v6

    :goto_66
    goto :goto_2e

    :cond_67
    move v0, v7

    goto :goto_66

    .line 124
    :cond_69
    const-string v11, "\n"

    invoke-virtual {v4, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_7c

    .line 125
    iget-object v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    sget-object v12, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->NEWLINE:Lcom/watabou/noosa/RenderedText;

    invoke-virtual {v11, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_78
    .catchall {:try_start_9 .. :try_end_78} :catchall_79

    goto :goto_2e

    .line 106
    .end local v0    # "Bhighlighting":Z
    .end local v1    # "Ghighlighting":Z
    .end local v2    # "Rhighlighting":Z
    .end local v3    # "highlighting":Z
    .end local v4    # "str":Ljava/lang/String;
    :catchall_79
    move-exception v6

    monitor-exit p0

    throw v6

    .line 126
    .restart local v0    # "Bhighlighting":Z
    .restart local v1    # "Ghighlighting":Z
    .restart local v2    # "Rhighlighting":Z
    .restart local v3    # "highlighting":Z
    .restart local v4    # "str":Ljava/lang/String;
    :cond_7c
    :try_start_7c
    const-string v11, " "

    invoke-virtual {v4, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_8c

    .line 127
    iget-object v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    sget-object v12, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->SPACE:Lcom/watabou/noosa/RenderedText;

    invoke-virtual {v11, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2e

    .line 130
    :cond_8c
    new-instance v5, Lcom/watabou/noosa/RenderedText;

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->size:I

    invoke-direct {v5, v4, v11}, Lcom/watabou/noosa/RenderedText;-><init>(Ljava/lang/String;I)V

    .line 132
    .local v5, "word":Lcom/watabou/noosa/RenderedText;
    if-eqz v3, :cond_bb

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->hightlightColor:I

    invoke-virtual {v5, v11}, Lcom/watabou/noosa/RenderedText;->hardlight(I)V

    .line 137
    :cond_9a
    :goto_9a
    iget-object v11, v5, Lcom/watabou/noosa/RenderedText;->scale:Lcom/watabou/utils/PointF;

    iget v12, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->zoom:F

    invoke-virtual {v11, v12}, Lcom/watabou/utils/PointF;->set(F)Lcom/watabou/utils/PointF;

    .line 139
    iget-object v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    invoke-virtual {v11, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 140
    invoke-virtual {p0, v5}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->add(Lcom/watabou/noosa/Gizmo;)Lcom/watabou/noosa/Gizmo;

    .line 142
    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->height:F

    invoke-virtual {v5}, Lcom/watabou/noosa/RenderedText;->height()F

    move-result v12

    cmpg-float v11, v11, v12

    if-gez v11, :cond_2e

    invoke-virtual {v5}, Lcom/watabou/noosa/RenderedText;->height()F

    move-result v11

    iput v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->height:F

    goto/16 :goto_2e

    .line 133
    :cond_bb
    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->color:I

    const/4 v12, -0x1

    if-eq v11, v12, :cond_c6

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->color:I

    invoke-virtual {v5, v11}, Lcom/watabou/noosa/RenderedText;->hardlight(I)V

    goto :goto_9a

    .line 134
    :cond_c6
    if-eqz v2, :cond_ce

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->RColor:I

    invoke-virtual {v5, v11}, Lcom/watabou/noosa/RenderedText;->hardlight(I)V

    goto :goto_9a

    .line 135
    :cond_ce
    if-eqz v1, :cond_d6

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->GColor:I

    invoke-virtual {v5, v11}, Lcom/watabou/noosa/RenderedText;->hardlight(I)V

    goto :goto_9a

    .line 136
    :cond_d6
    if-eqz v0, :cond_9a

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->BColor:I

    invoke-virtual {v5, v11}, Lcom/watabou/noosa/RenderedText;->hardlight(I)V

    goto :goto_9a

    .line 145
    .end local v4    # "str":Ljava/lang/String;
    .end local v5    # "word":Lcom/watabou/noosa/RenderedText;
    :cond_de
    invoke-virtual {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->layout()V
    :try_end_e1
    .catchall {:try_start_7c .. :try_end_e1} :catchall_79

    goto/16 :goto_7
.end method


# virtual methods
.method public declared-synchronized BHightlighting(Z)V
    .registers 3
    .param p1, "enabled"    # Z

    .prologue
    .line 213
    monitor-enter p0

    const v0, 0xff00

    :try_start_4
    invoke-virtual {p0, p1, v0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->setHightlighting(ZI)V
    :try_end_7
    .catchall {:try_start_4 .. :try_end_7} :catchall_9

    .line 214
    monitor-exit p0

    return-void

    .line 213
    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized BHightlighting(ZI)V
    .registers 4
    .param p1, "enabled"    # Z
    .param p2, "color"    # I

    .prologue
    .line 217
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->highlightingEnabled:Z

    if-ne p1, v0, :cond_9

    iget v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->hightlightColor:I

    if-eq p2, v0, :cond_10

    .line 218
    :cond_9
    iput p2, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->RColor:I

    .line 219
    iput-boolean p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->REnabled:Z

    .line 220
    invoke-direct {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->build()V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 222
    :cond_10
    monitor-exit p0

    return-void

    .line 217
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized GHightlighting(Z)V
    .registers 3
    .param p1, "enabled"    # Z

    .prologue
    .line 201
    monitor-enter p0

    const v0, 0xff00

    :try_start_4
    invoke-virtual {p0, p1, v0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->setHightlighting(ZI)V
    :try_end_7
    .catchall {:try_start_4 .. :try_end_7} :catchall_9

    .line 202
    monitor-exit p0

    return-void

    .line 201
    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized GHightlighting(ZI)V
    .registers 4
    .param p1, "enabled"    # Z
    .param p2, "color"    # I

    .prologue
    .line 205
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->highlightingEnabled:Z

    if-ne p1, v0, :cond_9

    iget v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->hightlightColor:I

    if-eq p2, v0, :cond_10

    .line 206
    :cond_9
    iput p2, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->RColor:I

    .line 207
    iput-boolean p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->REnabled:Z

    .line 208
    invoke-direct {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->build()V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 210
    :cond_10
    monitor-exit p0

    return-void

    .line 205
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized RHightlighting(Z)V
    .registers 3
    .param p1, "enabled"    # Z

    .prologue
    .line 189
    monitor-enter p0

    const/16 v0, 0xff

    :try_start_3
    invoke-virtual {p0, p1, v0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->setHightlighting(ZI)V
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_8

    .line 190
    monitor-exit p0

    return-void

    .line 189
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized RHightlighting(ZI)V
    .registers 4
    .param p1, "enabled"    # Z
    .param p2, "color"    # I

    .prologue
    .line 193
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->highlightingEnabled:Z

    if-ne p1, v0, :cond_9

    iget v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->hightlightColor:I

    if-eq p2, v0, :cond_10

    .line 194
    :cond_9
    iput p2, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->RColor:I

    .line 195
    iput-boolean p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->REnabled:Z

    .line 196
    invoke-direct {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->build()V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 198
    :cond_10
    monitor-exit p0

    return-void

    .line 193
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized align(I)V
    .registers 3
    .param p1, "align"    # I

    .prologue
    .line 240
    monitor-enter p0

    :try_start_1
    iput p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->alignment:I

    .line 241
    invoke-virtual {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->layout()V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 242
    monitor-exit p0

    return-void

    .line 240
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized alpha(F)V
    .registers 5
    .param p1, "value"    # F

    .prologue
    .line 171
    monitor-enter p0

    :try_start_1
    iget-object v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_7
    :goto_7
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1c

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/watabou/noosa/RenderedText;

    .line 172
    .local v0, "word":Lcom/watabou/noosa/RenderedText;
    if-eqz v0, :cond_7

    invoke-virtual {v0, p1}, Lcom/watabou/noosa/RenderedText;->alpha(F)V
    :try_end_18
    .catchall {:try_start_1 .. :try_end_18} :catchall_19

    goto :goto_7

    .line 171
    .end local v0    # "word":Lcom/watabou/noosa/RenderedText;
    :catchall_19
    move-exception v1

    monitor-exit p0

    throw v1

    .line 174
    :cond_1c
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized hardlight(I)V
    .registers 5
    .param p1, "color"    # I

    .prologue
    .line 157
    monitor-enter p0

    :try_start_1
    iput p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->color:I

    .line 158
    iget-object v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_9
    :goto_9
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1e

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/watabou/noosa/RenderedText;

    .line 159
    .local v0, "word":Lcom/watabou/noosa/RenderedText;
    if-eqz v0, :cond_9

    invoke-virtual {v0, p1}, Lcom/watabou/noosa/RenderedText;->hardlight(I)V
    :try_end_1a
    .catchall {:try_start_1 .. :try_end_1a} :catchall_1b

    goto :goto_9

    .line 157
    .end local v0    # "word":Lcom/watabou/noosa/RenderedText;
    :catchall_1b
    move-exception v1

    monitor-exit p0

    throw v1

    .line 161
    :cond_1e
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized invert()V
    .registers 4

    .prologue
    .line 225
    monitor-enter p0

    :try_start_1
    iget-object v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    if-eqz v1, :cond_3b

    .line 226
    iget-object v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_b
    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3b

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/watabou/noosa/RenderedText;

    .line 227
    .local v0, "word":Lcom/watabou/noosa/RenderedText;
    if-eqz v0, :cond_b

    .line 228
    const v2, 0x3f451eb8    # 0.77f

    iput v2, v0, Lcom/watabou/noosa/RenderedText;->ra:F

    .line 229
    const v2, 0x3f3ae148    # 0.73f

    iput v2, v0, Lcom/watabou/noosa/RenderedText;->ga:F

    .line 230
    const v2, 0x3f1eb852    # 0.62f

    iput v2, v0, Lcom/watabou/noosa/RenderedText;->ba:F

    .line 231
    const v2, -0x40bae148    # -0.77f

    iput v2, v0, Lcom/watabou/noosa/RenderedText;->rm:F

    .line 232
    const v2, -0x40c51eb8    # -0.73f

    iput v2, v0, Lcom/watabou/noosa/RenderedText;->gm:F

    .line 233
    const v2, -0x40e147ae    # -0.62f

    iput v2, v0, Lcom/watabou/noosa/RenderedText;->bm:F
    :try_end_37
    .catchall {:try_start_1 .. :try_end_37} :catchall_38

    goto :goto_b

    .line 225
    .end local v0    # "word":Lcom/watabou/noosa/RenderedText;
    :catchall_38
    move-exception v1

    monitor-exit p0

    throw v1

    .line 237
    :cond_3b
    monitor-exit p0

    return-void
.end method

.method protected declared-synchronized layout()V
    .registers 15

    .prologue
    const/4 v12, 0x1

    const/high16 v13, 0x40000000    # 2.0f

    .line 246
    monitor-enter p0

    :try_start_4
    invoke-super {p0}, Lcom/watabou/noosa/ui/Component;->layout()V

    .line 247
    iget v7, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->x:F

    .line 248
    .local v7, "x":F
    iget v8, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->y:F

    .line 249
    .local v8, "y":F
    const/4 v1, 0x0

    .line 250
    .local v1, "height":F
    const/4 v9, 0x1

    iput v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->nLines:I

    .line 252
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 253
    .local v4, "lines":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 254
    .local v0, "curLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 256
    const/4 v9, 0x0

    iput v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->width:F

    .line 257
    iget-object v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_25
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_ad

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/watabou/noosa/RenderedText;

    .line 258
    .local v6, "word":Lcom/watabou/noosa/RenderedText;
    sget-object v10, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->SPACE:Lcom/watabou/noosa/RenderedText;

    if-ne v6, v10, :cond_39

    .line 259
    const/high16 v10, 0x3fc00000    # 1.5f

    add-float/2addr v7, v10

    goto :goto_25

    .line 260
    :cond_39
    sget-object v10, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->NEWLINE:Lcom/watabou/noosa/RenderedText;

    if-ne v6, v10, :cond_54

    .line 262
    add-float v10, v1, v13

    add-float/2addr v8, v10

    .line 263
    iget v7, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->x:F

    .line 264
    iget v10, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->nLines:I

    add-int/lit8 v10, v10, 0x1

    iput v10, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->nLines:I

    .line 265
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "curLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 266
    .restart local v0    # "curLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_50
    .catchall {:try_start_4 .. :try_end_50} :catchall_51

    goto :goto_25

    .line 246
    .end local v0    # "curLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    .end local v1    # "height":F
    .end local v4    # "lines":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;>;"
    .end local v6    # "word":Lcom/watabou/noosa/RenderedText;
    .end local v7    # "x":F
    .end local v8    # "y":F
    :catchall_51
    move-exception v9

    monitor-exit p0

    throw v9

    .line 268
    .restart local v0    # "curLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    .restart local v1    # "height":F
    .restart local v4    # "lines":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;>;"
    .restart local v6    # "word":Lcom/watabou/noosa/RenderedText;
    .restart local v7    # "x":F
    .restart local v8    # "y":F
    :cond_54
    :try_start_54
    invoke-virtual {v6}, Lcom/watabou/noosa/RenderedText;->height()F

    move-result v10

    cmpl-float v10, v10, v1

    if-lez v10, :cond_60

    invoke-virtual {v6}, Lcom/watabou/noosa/RenderedText;->height()F

    move-result v1

    .line 270
    :cond_60
    iget v10, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->x:F

    sub-float v10, v7, v10

    invoke-virtual {v6}, Lcom/watabou/noosa/RenderedText;->width()F

    move-result v11

    add-float/2addr v10, v11

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->maxWidth:I

    int-to-float v11, v11

    cmpl-float v10, v10, v11

    if-lez v10, :cond_89

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v10

    if-nez v10, :cond_89

    .line 271
    add-float v10, v1, v13

    add-float/2addr v8, v10

    .line 272
    iget v7, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->x:F

    .line 273
    iget v10, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->nLines:I

    add-int/lit8 v10, v10, 0x1

    iput v10, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->nLines:I

    .line 274
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "curLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 275
    .restart local v0    # "curLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 278
    :cond_89
    iput v7, v6, Lcom/watabou/noosa/RenderedText;->x:F

    .line 279
    iput v8, v6, Lcom/watabou/noosa/RenderedText;->y:F

    .line 280
    invoke-static {v6}, Lcom/shatteredpixel/shatteredpixeldungeon/scenes/PixelScene;->align(Lcom/watabou/noosa/Visual;)V

    .line 281
    invoke-virtual {v6}, Lcom/watabou/noosa/RenderedText;->width()F

    move-result v10

    add-float/2addr v7, v10

    .line 282
    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 284
    iget v10, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->x:F

    sub-float v10, v7, v10

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->width:F

    cmpl-float v10, v10, v11

    if-lez v10, :cond_a8

    iget v10, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->x:F

    sub-float v10, v7, v10

    iput v10, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->width:F

    .line 288
    :cond_a8
    const/high16 v10, 0x3f000000    # 0.5f

    sub-float/2addr v7, v10

    goto/16 :goto_25

    .line 292
    .end local v6    # "word":Lcom/watabou/noosa/RenderedText;
    :cond_ad
    iget v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->y:F

    sub-float v9, v8, v9

    add-float/2addr v9, v1

    iput v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->height:F

    .line 294
    iget v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->alignment:I

    if-eq v9, v12, :cond_138

    .line 295
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_bc
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_138

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .line 296
    .local v2, "line":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-eqz v9, :cond_bc

    .line 297
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-virtual {v2, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/watabou/noosa/RenderedText;

    invoke-virtual {v9}, Lcom/watabou/noosa/RenderedText;->width()F

    move-result v11

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-virtual {v2, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/watabou/noosa/RenderedText;

    iget v9, v9, Lcom/watabou/noosa/RenderedText;->x:F

    add-float/2addr v9, v11

    iget v11, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->x:F

    sub-float v3, v9, v11

    .line 298
    .local v3, "lineWidth":F
    iget v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->alignment:I

    const/4 v11, 0x2

    if-ne v9, v11, :cond_115

    .line 299
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_fa
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_bc

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/watabou/noosa/RenderedText;

    .line 300
    .local v5, "text":Lcom/watabou/noosa/RenderedText;
    iget v11, v5, Lcom/watabou/noosa/RenderedText;->x:F

    invoke-virtual {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->width()F

    move-result v12

    sub-float/2addr v12, v3

    div-float/2addr v12, v13

    add-float/2addr v11, v12

    iput v11, v5, Lcom/watabou/noosa/RenderedText;->x:F

    .line 301
    invoke-static {v5}, Lcom/shatteredpixel/shatteredpixeldungeon/scenes/PixelScene;->align(Lcom/watabou/noosa/Visual;)V

    goto :goto_fa

    .line 303
    .end local v5    # "text":Lcom/watabou/noosa/RenderedText;
    :cond_115
    iget v9, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->alignment:I

    const/4 v11, 0x3

    if-ne v9, v11, :cond_bc

    .line 304
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_11e
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_bc

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/watabou/noosa/RenderedText;

    .line 305
    .restart local v5    # "text":Lcom/watabou/noosa/RenderedText;
    iget v11, v5, Lcom/watabou/noosa/RenderedText;->x:F

    invoke-virtual {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->width()F

    move-result v12

    sub-float/2addr v12, v3

    add-float/2addr v11, v12

    iput v11, v5, Lcom/watabou/noosa/RenderedText;->x:F

    .line 306
    invoke-static {v5}, Lcom/shatteredpixel/shatteredpixeldungeon/scenes/PixelScene;->align(Lcom/watabou/noosa/Visual;)V
    :try_end_137
    .catchall {:try_start_54 .. :try_end_137} :catchall_51

    goto :goto_11e

    .line 311
    .end local v2    # "line":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/watabou/noosa/RenderedText;>;"
    .end local v3    # "lineWidth":F
    .end local v5    # "text":Lcom/watabou/noosa/RenderedText;
    :cond_138
    monitor-exit p0

    return-void
.end method

.method public maxWidth()I
    .registers 2

    .prologue
    .line 102
    iget v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->maxWidth:I

    return v0
.end method

.method public maxWidth(I)V
    .registers 3
    .param p1, "maxWidth"    # I

    .prologue
    .line 94
    iget v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->maxWidth:I

    if-eq v0, p1, :cond_e

    .line 95
    iput p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->maxWidth:I

    .line 96
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->multiline:Z

    .line 97
    iget-object v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->text:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->text(Ljava/lang/String;)V

    .line 99
    :cond_e
    return-void
.end method

.method public declared-synchronized resetColor()V
    .registers 4

    .prologue
    .line 164
    monitor-enter p0

    const/4 v1, -0x1

    :try_start_2
    iput v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->color:I

    .line 165
    iget-object v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_a
    :goto_a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1f

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/watabou/noosa/RenderedText;

    .line 166
    .local v0, "word":Lcom/watabou/noosa/RenderedText;
    if-eqz v0, :cond_a

    invoke-virtual {v0}, Lcom/watabou/noosa/RenderedText;->resetColor()V
    :try_end_1b
    .catchall {:try_start_2 .. :try_end_1b} :catchall_1c

    goto :goto_a

    .line 164
    .end local v0    # "word":Lcom/watabou/noosa/RenderedText;
    :catchall_1c
    move-exception v1

    monitor-exit p0

    throw v1

    .line 168
    :cond_1f
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized setHightlighting(Z)V
    .registers 3
    .param p1, "enabled"    # Z

    .prologue
    .line 177
    monitor-enter p0

    const v0, 0xffff

    :try_start_4
    invoke-virtual {p0, p1, v0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->setHightlighting(ZI)V
    :try_end_7
    .catchall {:try_start_4 .. :try_end_7} :catchall_9

    .line 178
    monitor-exit p0

    return-void

    .line 177
    :catchall_9
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setHightlighting(ZI)V
    .registers 4
    .param p1, "enabled"    # Z
    .param p2, "color"    # I

    .prologue
    .line 181
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->highlightingEnabled:Z

    if-ne p1, v0, :cond_9

    iget v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->hightlightColor:I

    if-eq p2, v0, :cond_10

    .line 182
    :cond_9
    iput p2, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->hightlightColor:I

    .line 183
    iput-boolean p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->highlightingEnabled:Z

    .line 184
    invoke-direct {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->build()V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 186
    :cond_10
    monitor-exit p0

    return-void

    .line 181
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public text()Ljava/lang/String;
    .registers 2

    .prologue
    .line 90
    iget-object v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->text:Ljava/lang/String;

    return-object v0
.end method

.method public text(Ljava/lang/String;)V
    .registers 4
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->text:Ljava/lang/String;

    .line 75
    if-eqz p1, :cond_19

    const-string v0, ""

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_19

    .line 77
    sget-object v0, Lcom/watabou/noosa/Game;->platform:Lcom/watabou/utils/PlatformSupport;

    iget-boolean v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->multiline:Z

    invoke-virtual {v0, p1, v1}, Lcom/watabou/utils/PlatformSupport;->splitforTextBlock(Ljava/lang/String;Z)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->tokens:[Ljava/lang/String;

    .line 79
    invoke-direct {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->build()V

    .line 81
    :cond_19
    return-void
.end method

.method public text(Ljava/lang/String;I)V
    .registers 4
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "maxWidth"    # I

    .prologue
    .line 84
    iput p2, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->maxWidth:I

    .line 85
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->multiline:Z

    .line 86
    invoke-virtual {p0, p1}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->text(Ljava/lang/String;)V

    .line 87
    return-void
.end method

.method public declared-synchronized zoom(F)V
    .registers 5
    .param p1, "zoom"    # F

    .prologue
    .line 149
    monitor-enter p0

    :try_start_1
    iput p1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->zoom:F

    .line 150
    iget-object v1, p0, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->words:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_9
    :goto_9
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_20

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/watabou/noosa/RenderedText;

    .line 151
    .local v0, "word":Lcom/watabou/noosa/RenderedText;
    if-eqz v0, :cond_9

    iget-object v2, v0, Lcom/watabou/noosa/RenderedText;->scale:Lcom/watabou/utils/PointF;

    invoke-virtual {v2, p1}, Lcom/watabou/utils/PointF;->set(F)Lcom/watabou/utils/PointF;
    :try_end_1c
    .catchall {:try_start_1 .. :try_end_1c} :catchall_1d

    goto :goto_9

    .line 149
    .end local v0    # "word":Lcom/watabou/noosa/RenderedText;
    :catchall_1d
    move-exception v1

    monitor-exit p0

    throw v1

    .line 153
    :cond_20
    :try_start_20
    invoke-virtual {p0}, Lcom/shatteredpixel/shatteredpixeldungeon/ui/RenderedTextBlock;->layout()V
    :try_end_23
    .catchall {:try_start_20 .. :try_end_23} :catchall_1d

    .line 154
    monitor-exit p0

    return-void
.end method
