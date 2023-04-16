package com.example.hm1m7

import android.content.Context
import androidx.room.Room
import com.example.hm1m7.data.local.NoteDao
import com.example.hm1m7.data.local.NoteDatabase
import com.example.hm1m7.data.repository.NoteRepositoryImpl
import com.example.hm1m7.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteAppModule {

    @Provides
    @Singleton
//    fun provideRoomNoteDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
//        context, NoteDataBase::class.java, "notes"
//    )
    fun provideRoomNoteDataBase(@ApplicationContext context: Context):NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java,"notes").allowMainThreadQueries().build()



    @Provides
    fun provideNoteDao(noteDataBase: NoteDatabase) = noteDataBase.noteDao()


    @Provides
    fun provideNOteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)
}