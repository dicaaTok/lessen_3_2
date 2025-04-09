package com.ui.intetface

import com.data.models.NoteModel

interface OnClickItem {
    fun OnLongClick(noteModel: NoteModel)

    fun onClick(noteModel: NoteModel)
}